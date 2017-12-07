package org.somox.analyzer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.somox.core.Activator;
import org.somox.kdmhelper.KDMReader;
import org.somox.kdmhelper.metamodeladdition.Root;


/**
 * @author  Snowball
 */
public class ModelAnalyzerTabGroupBlackboard {

    /**
     * @uml.property  name="root"
     * @uml.associationEnd
     */
    private Root root;

    private final ComposedAdapterFactory adapterFactory;

    static int idCounter = 0;
    private final int myId;

    private final ILog logger = Activator.getPlugin().getLog();

    public ModelAnalyzerTabGroupBlackboard() {
        super();
        idCounter++;
        myId = idCounter;

        adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
    }

    public int getId() {
        return myId;
    }

    /**
     * @uml.property  name="somoxAnalyzerInputFile"
     */
    private String somoxAnalyzerInputFile = null;

    /**
     * @uml.property  name="debugLvl"
     */
    private Level debugLvl = Level.INFO;

    /**
     * @return
     * @uml.property  name="debugLvl"
     */
    public Level getDebugLvl() {
        return debugLvl;
    }

    public void setDebugLvl(final int debugLvl) {
        switch (debugLvl) {
        case 0: this.debugLvl = Level.INFO; break;
        case 1: this.debugLvl = Level.DEBUG; break;
        default: this.debugLvl = Level.ALL;
        }
    }

    /**
     * @return
     * @uml.property  name="somoxAnalyzerInputFile"
     */
    public String getSomoxAnalyzerInputFile() {
        return somoxAnalyzerInputFile;
    }

    /**
     * @param somoxAnalyzerInputFile
     * @uml.property  name="somoxAnalyzerInputFile"
     */
    public void setSomoxAnalyzerInputFile(final String somoxAnalyzerInputFile) {
        if (somoxAnalyzerInputFile == null && this.somoxAnalyzerInputFile != null) {
            root = null;
            this.somoxAnalyzerInputFile = null;
            fireBlackboardChanged();
            return;
        }

        this.somoxAnalyzerInputFile = somoxAnalyzerInputFile;
        if (somoxAnalyzerInputFile.endsWith(".xmi")) {
            loadModel();
        } else {
            root = null;
        }
    }

    private void loadModel() {

        final URI fileURI = URI.createPlatformResourceURI(somoxAnalyzerInputFile, true);

        final IWorkspaceRoot resRoot = ResourcesPlugin.getWorkspace().getRoot();
        if(resRoot.findMember(fileURI.toPlatformString(true)) instanceof IFile) {
            try {
                root=KDMReader.loadFile(fileURI);
                fireBlackboardChanged();
            } catch (final IOException e1) {
                logger.log(new Status(Status.ERROR,Activator.PLUGIN_ID,"Failed to load Model file " + fileURI));
                e1.printStackTrace();
            }
        }else {
            logger.log(new Status(Status.ERROR,Activator.PLUGIN_ID,"Failed to load Model file " + fileURI));
        }
    }

    /**
     * @return
     * @uml.property  name="root"
     */
    public Root getRoot () {
        return root;
    }

    //
    // Event handling
    //
    private final LinkedList<BlackboardListener> blackboardListeners = new LinkedList<BlackboardListener>();

    /** Register a listener for Blackboard events */
    synchronized public void addBlackboardListener(final BlackboardListener listener) {
        blackboardListeners.add(listener);
    }

    synchronized public void removeBlackboardListener(final BlackboardListener listener) {
        if (blackboardListeners.contains(listener)){
            blackboardListeners.remove(listener);
        }
    }

    /** Fire to all registered listeners */
    @SuppressWarnings("unchecked")
    public void fireBlackboardChanged() {
        if (!blackboardListeners.isEmpty()) {
            // Make a copy of the listener list in case anyone adds or removes
            // listeners.
            final List<BlackboardListener> targets;
            synchronized (blackboardListeners) {
                targets = (List<BlackboardListener>) blackboardListeners.clone();
            }
            for (final BlackboardListener l : targets) {
                l.blackboardChanged();
            }
        }
    }

}
