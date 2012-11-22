package org.somox.analyzer.simplemodelanalyzer.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.simplemodelanalyzer.builder.util.InterfacePortBuilderHelper;
import org.somox.analyzer.simplemodelanalyzer.detection.ComponentInterfaceStrategy;
import org.somox.analyzer.simplemodelanalyzer.detection.IComponentInterfaceStrategy;
import org.somox.analyzer.simplemodelanalyzer.detection.util.AccessFilter;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.filter.EClassBasedFilter;

import de.fzi.gast.accesses.Access;
import de.fzi.gast.accesses.InheritanceTypeAccess;
import de.fzi.gast.accesses.accessesPackage;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;
import eu.qimpress.samm.staticstructure.ComponentType;
import eu.qimpress.samm.staticstructure.CompositeStructure;
import eu.qimpress.samm.staticstructure.Interface;
import eu.qimpress.samm.staticstructure.InterfacePort;
import eu.qimpress.samm.staticstructure.PrimitiveComponent;
import eu.qimpress.samm.staticstructure.StaticstructureFactory;
import eu.qimpress.sourcecodedecorator.ComponentImplementingClassesLink;
import eu.qimpress.sourcecodedecorator.InterfaceSourceCodeLink;
import eu.qimpress.sourcecodedecorator.SourceCodeDecoratorFactory;

/**
 * Builder used to create {@link Interface}s in the SAMM instance based on reverse engineered 
 * code
 * 
 * @author Steffen Becker, Michael Hauck, Klaus Krogmann
 */
public class InterfaceBuilder extends AbstractBuilder {

	/**
	 * Maps GASTClasses which are interfaces (in case of Interfaces created directly from programming language 
	 * interfaces) or normal GASTClasses if the interface has been derived from all public methods
	 * to their respective SAMM model interfaces
	 */
	private Map<GASTClass, Interface> alreadyCreatedInterfaces = new HashMap<GASTClass, Interface>();

	/**
	 * Logger of this builder 
	 */
	private static Logger logger = Logger.getLogger(InterfaceBuilder.class);

	/**
	 * Builder used to build methods and method signatures 
	 */
	private OperationBuilder operationBuilder = null;
	
	/**
	 * Builder used to build GAST Behaviours for provided methods 
	 */
	private GASTBehaviourBuilder behaviourBuilder = null;

	/**
	 * Strategy for naming elements
	 */
	private ComponentAndTypeNaming naming = null;
	
	/**
	 * Strategy to identify classes as component interfaces
	 */
	private IComponentInterfaceStrategy interfaceStrategy = null;
	
	/**
	 * Constant indicating the case of a provided interface.
	 */
	public static final boolean PROVIDED_INTERFACE = true;
	
	/**
	 * Constructor of this interface builder
	 * @param gastModel GAST model used in queries to the source code
	 * @param configuration Somox configuration used to retrieve settings
	 * @param result The analysis result containing the root nodes of the models in which this builder will store
	 * the created model elements
	 */
	public InterfaceBuilder(Root gastModel, 
			SoMoXConfiguration configuration,
			AnalysisResult result) {
		super(gastModel, configuration, result);

		logger.debug("Interface builder initialised");

		this.operationBuilder = new OperationBuilder(gastModel, configuration,
				result);
		this.behaviourBuilder = new GASTBehaviourBuilder(gastModel, configuration,
				result);
		
		//TODO: extract to configurable strategy
		this.naming = new ComponentAndTypeNaming();

		//TODO: extract to configurable strategy
		this.interfaceStrategy = new ComponentInterfaceStrategy(result.getSourceCodeDecoratorRepository());
	}

	/**
	 * Method used to find for a given component the set of required interfaces. Currently
	 * interfaces are detected using a {@link IComponentInterfaceStrategy}. 
	 * @param componentCandidate The component for which this method should create 
	 * required interfaces
	 * @return true if a interface was added; false else
	 */
	public boolean findAndAddRequiredInterfaces(
			ComponentImplementingClassesLink componentCandidate) {
		boolean addedARequiredInterface = false;
		
		// Filter used to remove inheritance type relations from the list of accesses
		EClassBasedFilter<Access> accessFilter = new EClassBasedFilter<Access>(
				new EClass[] { 
						accessesPackage.eINSTANCE.getInheritanceTypeAccess(), 
						accessesPackage.eINSTANCE.getSelfAccess() //remove class-internal accesses
						});	

		// Get all accessed classes from all implementation classes of this
		// component
		List<GASTClass> filteredAccessedClasses = new LinkedList<GASTClass>();		
		List<GASTClass> componentClasses = new LinkedList<GASTClass>();
		for (GASTClass clazz : componentCandidate.getImplementingClasses()) {
			filteredAccessedClasses.addAll(AccessFilter.filterAccessList(clazz
					.getAllAccesses(), accessFilter));
			componentClasses.add(clazz);
		}
		
		// remove self accesses inside component (NOT equal to a self access)
		filteredAccessedClasses.removeAll(componentClasses);
		
		for (GASTClass accessedClass : this.somoxConfiguration.getBlacklistFilter().filter(filteredAccessedClasses)) {
			if (interfaceStrategy.isComponentInterface(accessedClass)) {
				
				// Setting null here since the interface implementation is not generally known; i. e. there could be multiple
				// implementations.
				Interface reqInterface = createInterface(null,accessedClass); 

				// If the interface has already been added to component, do not
				// add it again
				if (!doesComponentAlreadyRequireInterface(reqInterface,
						componentCandidate.getComponent())) {
					createRequiredPort(componentCandidate.getComponent(),
							reqInterface);
					//update source code decorator:
					updateInterfacesInSourceCodeDecorator(componentCandidate, reqInterface, accessedClass, !PROVIDED_INTERFACE);
					
					addedARequiredInterface = true;
				}
			}
		}
		
		// for potentially existing interfaces of the component: avoid self accesses
		// to interfaces provided by the component		
		if(!componentCandidate.isCompositeComponent()) {
			removeInterfaceSelfAccesses(componentCandidate);
		}
		
		return addedARequiredInterface;
	}

	/**
	 * Create provided roles and their interfaces if they do not exist for the given component
	 * @param componentCandidate Source code annotation of the detected component for which the 
	 * provided interfaces should be created. It has to point to a {@link PrimitiveComponent}.
	 */
	public void addProvidedInterfaces(
			ComponentImplementingClassesLink componentCandidate) {
	
		// Check precondition
		if (componentCandidate.isCompositeComponent())
			throw new IllegalArgumentException("This method can only be called on primitive components");
		
		for (GASTClass gastClass : componentCandidate.getImplementingClasses()) {
			for (GASTClass superType : this.somoxConfiguration.getBlacklistFilter().filter(gastClass.getSuperTypes())) {
				createInterfaceForSupertype(componentCandidate, gastClass,
						superType);
			}
		}

		if (componentCandidate.getComponent().getProvided().isEmpty()) {
			assignPublicMethodsAsInterfaceForComponentsWithoutInterface(componentCandidate);
		}		
	}

	/**
	 * Add the given interface in a required role to the given component
	 * @param component The component which gets the interface as required role
	 * @param reqInterface The interface which is part of the required role
	 */
	private void createRequiredPort(ComponentType component,
			Interface reqInterface) {
		InterfacePort reqInterfacePort = StaticstructureFactory.eINSTANCE
				.createInterfacePort();
		reqInterfacePort.setName(naming.createRequiredPortName(reqInterface, component));
		reqInterfacePort.setInterfaceType(reqInterface);
		component.getRequired().add(reqInterfacePort);
	}

	private InterfacePort createProvidedPort(Interface theInterface,
			ComponentType component) {
		InterfacePort provInterfacePort = StaticstructureFactory.eINSTANCE
				.createInterfacePort();
		provInterfacePort.setName(naming.createProvidedPortName(theInterface, component));
		provInterfacePort.setInterfaceType(theInterface);
		component.getProvided().add(provInterfacePort);		
		return provInterfacePort;
	}

	/**
	 * Checks whether the given component requires the given interface.
	 * 
	 * @param theInterface
	 * @param component
	 * @return true if already required; false else
	 */
	private boolean doesComponentAlreadyRequireInterface(
			Interface theInterface, ComponentType component) {
		for (InterfacePort port : component.getRequired()) {
			if ((port.getInterfaceType() != null)
					&& (port.getInterfaceType().getId().equals(theInterface
							.getId()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param theInterface Interface to search
	 * @param component Component whose provided roles are checked
	 * @return true if the given interface is referenced in any of the provided ports of the component
	 */
	private boolean componentProvidesInterface(Interface theInterface,
			ComponentType component) {
		for (InterfacePort port : component.getProvided()) {
			if ((port.getInterfaceType() != null)
					&& (port.getInterfaceType().getId().equals(theInterface
							.getId()))) {
				return true;
			}
		}
		return false;
	}

	private void createInterfaceForSupertype(
			ComponentImplementingClassesLink componentCandidate,
			GASTClass gastClass, GASTClass superType) {
		
		// Recursively traverse all supertypes
		for (GASTClass ownSuperType : this.somoxConfiguration.getBlacklistFilter().filter(superType.getSuperTypes())) {
			createInterfaceForSupertype(componentCandidate, gastClass, ownSuperType);
		}
		
		if (interfaceStrategy.isComponentInterface(superType)) {
			logger.debug("Found interface "+superType.getQualifiedName()+" for component "+componentCandidate.getComponent().getName());
			Interface providedInterface = createInterface(gastClass,superType);
			
			if (!componentProvidesInterface(providedInterface,
					componentCandidate.getComponent())) {
				createProvidedPortAndBehaviour(componentCandidate,
						providedInterface, superType);
			}
		}
	}

	private void createProvidedPortAndBehaviour(
			ComponentImplementingClassesLink componentCandidate,
			Interface providedInterface, 
			GASTClass gastClass) {
		InterfacePort providedPort = createProvidedPort(providedInterface,
				componentCandidate.getComponent());

		updateInterfacesInSourceCodeDecorator(
				componentCandidate,
				providedInterface,
				gastClass,
				true //provided interface
				);

		if (!componentCandidate.isCompositeComponent()) {
			// add behaviour
			behaviourBuilder.addGASTBehaviourToPrimitiveComponent((PrimitiveComponent) componentCandidate.getComponent(), providedPort);
		}
	}

	/**
	 * Finally, check if components exist that do not provide any interfaces. This components should
	 * then provide an interface with all public methods
	 * @param myComponentsGast Map of existing components 
	 */
	private void assignPublicMethodsAsInterfaceForComponentsWithoutInterface(
			ComponentImplementingClassesLink componentCandidate) {
		logger.debug("Assigning public methods as interfaces");

		List<GASTClass> gastClasses = componentCandidate.getImplementingClasses();
		
		if( !gastClasses.isEmpty() ) {
			for(GASTClass gastClass : gastClasses) {
					
				Interface compInterface = createInterfaceBasedOnPublicMethods(gastClass);

				if (compInterface != null) {
					createProvidedPortAndBehaviour(componentCandidate,
							compInterface,gastClass);
				} else {
					logger.warn("Failed to create interface by using public methods for class without real interfaces");
				}
			}
		} else {
			logger.warn("No gast classes found for component: " + componentCandidate.getComponent().getName() + " id: " + componentCandidate.getComponent().getId());
		}
	}	
	
	/**
	 * Creates a new interface for the given gastClass if it was
	 * not present in allInterfaces before. 
	 * @param gastClass interface is created for the public methods of this class 
	 * @return A new interface if a interface for gastClass did not exist;
	 * otherwise the existing interface is returned
	 */
	private Interface createInterfaceBasedOnPublicMethods(
			GASTClass gastClass) {	
		
		if (interfaceStrategy.isComponentInterface(gastClass))
			logger.info(gastClass.getQualifiedName() + " used as interface but is a pseudo-interface.");
				
		if(this.alreadyCreatedInterfaces.containsKey(gastClass)) 
			return this.alreadyCreatedInterfaces.get(gastClass);

		Interface compInterface = StaticstructureFactory.eINSTANCE.createInterface();			
		compInterface.setName(naming.createInterfaceNameForClass(gastClass));
		compInterface.setDocumentation(gastClass.getSimpleName());
			
		this.operationBuilder.createOperations(gastClass, gastClass,compInterface);
		
		this.alreadyCreatedInterfaces.put(gastClass, compInterface);
		this.analysisResult.getInternalArchitectureModel().getInterface().add(compInterface);

		return compInterface;
	}
	
	/**
	 * 
	 * @param interfaceClass
	 *            the interface to add for gastClass
	 * @param interfaces
	 *            a list of interfaces in which the interface should be put. If
	 *            the interface is already contained in the list, this interface
	 *            is returned
	 * @param repository
	 *            the SAMM repository in which the interface should be contained
	 * @return the interface
	 */
	private Interface createInterface(GASTClass implementingClass, GASTClass interfaceClass) {	
		
		// check for existing interface:
		Interface result = getExistingInterface(interfaceClass);
	
		// new interface
		if (result == null) {
			result = StaticstructureFactory.eINSTANCE.createInterface();
			for (InheritanceTypeAccess inheritanceTypeAccess : interfaceClass
					.getInheritanceTypeAccesses()) {
				GASTClass superType = (GASTClass) inheritanceTypeAccess
						.getTargetType();
				if (this.somoxConfiguration.getBlacklistFilter().passes(superType) &&
						interfaceStrategy.isComponentInterface(superType)) {
					Interface parentInterface = createInterface(implementingClass, (GASTClass) superType);
					result.getInheritance().add(parentInterface);
				}
			}
			result.setName(naming.createInterfaceName(interfaceClass));
			result.setDocumentation(interfaceClass.getQualifiedName());
	
			operationBuilder.createOperations(implementingClass, interfaceClass, result);  
	
			this.alreadyCreatedInterfaces.put(interfaceClass, result);
			this.analysisResult.getInternalArchitectureModel().getInterface()
					.add(result);
		}
		return result;
	}

	/**
	 * Checks whether the interface is already present (created before)
	 * 
	 * @param gastClass
	 * @param interfaces
	 * @return null if no interface could not be found
	 */
	private Interface getExistingInterface(GASTClass gastClass) {
		Interface returnInterface = null;
	
		if (this.alreadyCreatedInterfaces.containsKey(gastClass)) {
			returnInterface = this.alreadyCreatedInterfaces.get(gastClass);
		}
	
		return returnInterface;
	}

	/**
	 * save source information to a interface link of the sourceCodeDecorator
	 * 
	 * @param component
	 *            write target
	 * @param interf The interface to add
	 * @param gastClass
	 *            an GAST <b>interface</b>
	 * @param isProvidedInterface set to true when adding a provided interface;
	 * vice versa for required interface  
	 */
	private void updateInterfacesInSourceCodeDecorator(
			ComponentImplementingClassesLink component,
			Interface interf,
			GASTClass gastClass, 
			boolean isProvidedInterface) {
		InterfaceSourceCodeLink interfaceLink = SourceCodeDecoratorFactory.eINSTANCE.createInterfaceSourceCodeLink();
		if (gastClass != null) {
			interfaceLink.setGastClass(gastClass);
		}
		interfaceLink.setInterface(interf);
		
		this.analysisResult.getSourceCodeDecoratorRepository()
				.getInterfaceSourceCodeLink().add(interfaceLink);
		if(isProvidedInterface) {
			component.getProvidedInterfaces().add(interfaceLink);
		} else {
			component.getRequiredInterfaces().add(interfaceLink);
		}
	}
	
	/**
	 * Updates the component interfaces of all interface
	 * existing until now in the source code decorator. The interfaces
	 * might have changed due to newly discovered interfaces during reverse
	 * engineering.
	 */
	public void updateRequiredInterfacesOfExistingPrimitiveComponents() {
		boolean addedANewInterface = false;
		
		for(ComponentImplementingClassesLink compLink : analysisResult.getSourceCodeDecoratorRepository().getComponentImplementingClassesLink()) {
			if(!compLink.isCompositeComponent()) {
				addedANewInterface = findAndAddRequiredInterfaces(compLink);
				addedANewInterface = true;
			}
		}
		
		// assembly connector builder: for new interfaces (assembly connectors for surrounding composites)
		IAssemblyConnectorStrategy assemblyConnectorStrategy = new AssemblyConnectorsInsideCompositeComponentStrategy();
		if(addedANewInterface) {			
			for(ComponentImplementingClassesLink compLink : analysisResult.getSourceCodeDecoratorRepository().getComponentImplementingClassesLink()) {
				if(compLink.isCompositeComponent()) {
					CompositeStructure composite = (CompositeStructure)compLink.getComponent();
					
					assemblyConnectorStrategy.buildAssemblyConnectors(composite, compLink.getSubComponents());
				}
			}		
		}
		
		//FIXME: can ripple through entire architecture
	}

	/**
	 * Adds interfaces from the GAST which have not yet been identified
	 * as component interfaces to the SAMM repository.
	 * @param analysisResult
	 * @param gastModel
	 */
	public void reverseEngineerRemainingInterfacesAsFreeFloatingInterfaces(
			AnalysisResult analysisResult, Root gastModel) {
		analysisResult.getSourceCodeDecoratorRepository();
		for(GASTClass currentClass : gastModel.getAllNormalClasses()) {
			if(interfaceStrategy.isComponentInterface(currentClass) &&
					!alreadyCreatedInterfaces.containsKey(currentClass)) {
				
				//create a new interface
				Interface newInterface = createInterface(currentClass, currentClass);				
				analysisResult.getInternalArchitectureModel().getInterface().add(newInterface);
				
				//update source code decorator
				InterfaceSourceCodeLink ifLink = SourceCodeDecoratorFactory.eINSTANCE.createInterfaceSourceCodeLink();
				ifLink.setGastClass(currentClass);
				analysisResult.getSourceCodeDecoratorRepository().getInterfaceSourceCodeLink().add(ifLink);
			}
		}		
	}

	/**
	 * Removes duplicate component interfaces which are provided AND required.
	 * Cleans ups the required interface ports. Since provided ports could 
	 * be accessed from elsewhere, they are fully preserved.
	 * @param primitiveComponent
	 */
	public void removeInterfaceSelfAccesses(
			ComponentImplementingClassesLink primitiveComponent) {

		List<InterfaceSourceCodeInterfacePortTuple> requiredIfToRemove = 
			identifyComponentInterfaceSelfAccess(primitiveComponent);
		
		for(InterfaceSourceCodeInterfacePortTuple currentIfTupleToRemove : requiredIfToRemove) {
			logger.trace("removing self-access component interface " + 
					currentIfTupleToRemove.interfaceSourceCodeLink.getInterface().getName() + 
					" of component " + primitiveComponent.getComponent().getName()); 
			
			// model	
			primitiveComponent.getComponent().getRequired().remove(currentIfTupleToRemove.interfacePort); 
			EcoreUtil.delete(currentIfTupleToRemove.interfacePort);
			//EcoreUtil.remove(requiredPortToRemove);				
			
			// source code decorator
			primitiveComponent.getRequiredInterfaces().remove(currentIfTupleToRemove.interfaceSourceCodeLink);
			EcoreUtil.delete(currentIfTupleToRemove.interfaceSourceCodeLink);
			//EcoreUtil.remove(currentReqIfLink);

		}
	}
	
	/**
	 * Queries interfaces which are provided AND required by a component.
	 * @param primitiveComponent The component to check interface ports for.
	 * @return Ports and source code decorator for the identified interfaces.
	 */
	private List<InterfaceSourceCodeInterfacePortTuple> identifyComponentInterfaceSelfAccess(
			ComponentImplementingClassesLink primitiveComponent) {
		
		ArrayList<InterfaceSourceCodeInterfacePortTuple> requiredIfToRemove = 
			new ArrayList<InterfaceSourceCodeInterfacePortTuple>();
		
		for(InterfaceSourceCodeLink providedInterfaceLink : primitiveComponent.getProvidedInterfaces()) {			
			for(InterfaceSourceCodeLink requiredInterfaceLink : primitiveComponent.getRequiredInterfaces()) {
				if(providedInterfaceLink.getInterface().equals(
						requiredInterfaceLink.getInterface() )) {
										
					InterfaceSourceCodeInterfacePortTuple ifToRemoveTuple = 
						new InterfaceSourceCodeInterfacePortTuple();

					// model
					ifToRemoveTuple.interfacePort = InterfacePortBuilderHelper.
						getInterfacePort(primitiveComponent,requiredInterfaceLink, false);	

					// source code decorator
					ifToRemoveTuple.interfaceSourceCodeLink = requiredInterfaceLink;
					
					requiredIfToRemove.add(ifToRemoveTuple);
				}
			}
		}	
		
		return requiredIfToRemove;		
	}
	
	private class InterfaceSourceCodeInterfacePortTuple {
		public InterfaceSourceCodeLink interfaceSourceCodeLink;
		public InterfacePort interfacePort;
	}
	

}