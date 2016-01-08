package org.somox.analyzer.simplemodelanalyzer;

import java.util.LinkedList;
import java.util.List;

import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.qosannotations.QoSAnnotations;
import org.palladiosimulator.pcm.repository.Repository;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.ModelAnalyzer;
import org.somox.common.Message;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

//import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;

/**
 * @author  Snowball
 */
public class SimpleAnalysisResult implements AnalysisResult {

    // ---------------------------------
    // Static Data Fields
    // ---------------------------------

    // ---------------------------------
    // Data fields
    // ---------------------------------

    /**
     * The executed model analyzer
     * @uml.property  name="modelAnalyzer"
     * @uml.associationEnd
     */
    private ModelAnalyzer modelAnalyzer = null;

    /**
     * The result status
     * @uml.property name="resultStatus"
     * @uml.associationEnd
     */
    private ResultStatus resultStatus = AnalysisResult.ResultStatus.NOT_EXECUTED;

    /**
     * the internal architecture model resulting from the performed analysis
     * @uml.property  name="internalArchitectureModel"
     * @uml.associationEnd
     */
    private Repository internalArchitectureModel = null;

    /**
     * the source code decorator repository
     * @uml.property  name="sourceCodeDecoratorRepository"
     * @uml.associationEnd
     */
    private SourceCodeDecoratorRepository sourceCodeDecoratorRepository = null;

    private org.palladiosimulator.pcm.system.System system = null;

    private Allocation allocation = null;

    private QoSAnnotations qosAnnotationModel = null;

    /**
     * The list of messages
     * @uml.property  name="messages"
     */
    private final List<Message> messages = new LinkedList<Message>();

    // ---------------------------------
    // Constructor
    // ---------------------------------

    public SimpleAnalysisResult(final ModelAnalyzer analyzer){
        this.modelAnalyzer = analyzer;
    }

    // ---------------------------------
    // Business Methods
    // ---------------------------------

    // ---------------------------------
    // Helper Methods
    // ---------------------------------

    // ---------------------------------
    // Getters / Setters
    // ---------------------------------

    /**
     * @return
     * @uml.property  name="modelAnalyzer"
     */
    @Override
    public ModelAnalyzer getModelAnalyzer() {
        return this.modelAnalyzer;
    }

    /**
     * @return
     * @uml.property  name="resultStatus"
     */
    @Override
    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    /**
     * @return
     * @uml.property  name="internalArchitectureModel"
     */
    @Override
    public Repository getInternalArchitectureModel() {
        return internalArchitectureModel;
    }



    /**
     * @param internalArchitectureModel  the internalArchitectureModel to set
     * @uml.property  name="internalArchitectureModel"
     */
    public void setInternalArchitectureModel(final Repository internalArchitectureModel) {
        this.internalArchitectureModel = internalArchitectureModel;
    }

    /**
     * @return
     * @uml.property  name="sourceCodeDecoratorRepository"
     */
    @Override
    public SourceCodeDecoratorRepository getSourceCodeDecoratorRepository() {
        return sourceCodeDecoratorRepository;
    }

    /**
     * @param sourceCodeDecoratorRepository
     * @uml.property  name="sourceCodeDecoratorRepository"
     */
    public void setSourceCodeDecoratorRepository(
            final SourceCodeDecoratorRepository sourceCodeDecoratorRepository) {
        this.sourceCodeDecoratorRepository = sourceCodeDecoratorRepository;
    }

    @Override
    public void addMessage(final Message message) {
        this.messages.add(message);
    }

    /**
     * @return
     * @uml.property  name="messages"
     */
    @Override
    public List<Message> getMessages() {
        return this.messages;
    }

    /**
     * @param status  the status to set
     * @uml.property  name="resultStatus"
     */
    public void setResultStatus(final ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    /*
     * (non-Javadoc)
     * @see org.somox.analyzer.AnalysisResult#getServiceArchitectureModel()
     */
    @Override
    public org.palladiosimulator.pcm.system.System getSystemModel() {
        return this.system;
    }

    public void setSystemModel(final org.palladiosimulator.pcm.system.System system) {
        this.system = system;
    }

    @Override
    public QoSAnnotations getQosAnnotationModel() {
        return qosAnnotationModel;
    }

    public void setQosAnnotationModel( final QoSAnnotations qosAnnotationModel) {
        this.qosAnnotationModel = qosAnnotationModel;
    }


    public void setAllocation( final Allocation allocation) {
        this.allocation = allocation;
    }

    @Override
    public Allocation getAllocation() {
        return this.allocation;
    }
}
