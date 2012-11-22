package org.somox.analyzer.simplemodelanalyzer.detection;

import de.fzi.gast.functions.Method;
import de.fzi.gast.types.GASTClass;
import eu.qimpress.sourcecodedecorator.InterfaceSourceCodeLink;
import eu.qimpress.sourcecodedecorator.SourceCodeDecoratorRepository;

/**
 * Default interface detection strategy.
 * Conditions in GAST: interface or only virtual methods which is not primitive
 * or identified a component interface before (e.g. public methods used as
 * component interface due to a fall back strategy).  
 * @author Klaus Krogmann
 *
 */
public class ComponentInterfaceStrategy implements IComponentInterfaceStrategy {
	
	private SourceCodeDecoratorRepository sourceCodeDecorator;
	
	/**
	 * Default ctor for this strategy.
	 * @param sourceCodeDecorator decorator to check for (additional) interfaces which
	 * are to be considered as component interfaces. Interfaces from the source code
	 * decorator are considered as whitelisted.
	 */
	public ComponentInterfaceStrategy(SourceCodeDecoratorRepository sourceCodeDecorator) {
		this.sourceCodeDecorator = sourceCodeDecorator;
	}

	/* (non-Javadoc)
	 * @see org.somox.analyzer.simplemodelanalyzer.detection.IComponentInterfaceStrategy#isComponentInterface(de.fzi.gast.types.GASTClass)
	 */
	public boolean isComponentInterface(GASTClass classToCheck) {
		return 
			isRegularInterface(classToCheck) || 
			isPureVirtualClass(classToCheck) || 
			isClassifiedAsInterfaceViaSourceCodeDecorator(classToCheck);
	}
		
	/**
	 * Checks whether the class has been identified as interface by
	 * the SISSy GAST model. 
	 * @param classToCheck class to check for component interface status.
	 * @return true if interface flag is set.
	 */
	private boolean isRegularInterface(GASTClass classToCheck) {
		return classToCheck.isInterface();
	}

	/**
	 * Checks whether the class (even if no real interface) was used as an interface in previous iterations
	 * as a fall back solution. Then, the class -- although being only an usual class -- is considered
	 * a component interface here to ensure consistency. 
	 * @param classToCheck The class to check in for in the source code decorator.
	 * @return true if the class appears in the source code decorator. 
	 */
	private boolean isClassifiedAsInterfaceViaSourceCodeDecorator(GASTClass classToCheck) {
		for(InterfaceSourceCodeLink ifLink : sourceCodeDecorator.getInterfaceSourceCodeLink()) {
			if(ifLink.getGastClass().equals(classToCheck)) {
				return true;
			}
		}
		return false;	
	}

	/**
	 * Checks whether all methods of a class are virtual and whether methods
	 * exist. This can be interpreted as having an interface class.
	 * @param classToCheck The class to check
	 * @return true if all methods are declared virtual; false else
	 */
	private boolean isPureVirtualClass(GASTClass classToCheck) {
		
		// do not consider "empty" classes with no methods as interface
		if(classToCheck.getMethods().size() == 0) {
			return false;
		}
		for(Method method : classToCheck.getMethods()) {
			if(!method.isVirtual()) {
				return false;
			}
			if (method.getBody() != null) {
				return false;
			}
		}
		return true;
	}
}