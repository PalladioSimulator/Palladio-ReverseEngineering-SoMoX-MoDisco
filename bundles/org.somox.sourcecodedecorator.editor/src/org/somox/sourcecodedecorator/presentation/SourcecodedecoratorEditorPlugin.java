/**
 */
package org.somox.sourcecodedecorator.presentation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.gmt.modisco.java.emf.provider.JavaEditPlugin;
import org.eclipse.gmt.modisco.omg.kdm.core.provider.KdmEditPlugin;
import org.palladiosimulator.pcm.core.provider.PalladioComponentModelEditPlugin;

import de.uka.ipd.sdq.identifier.provider.IdentifierEditPlugin;
import de.uka.ipd.sdq.probfunction.provider.ProbabilityFunctionEditPlugin;
import de.uka.ipd.sdq.stoex.provider.StoexEditPlugin;
import de.uka.ipd.sdq.units.provider.UnitsEditPlugin;

/**
 * This is the central singleton for the Sourcecodedecorator editor plugin. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public final class SourcecodedecoratorEditorPlugin extends EMFPlugin {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright by palladiosimulator.org, 2008-2016";

    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final SourcecodedecoratorEditorPlugin INSTANCE = new SourcecodedecoratorEditorPlugin();

    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SourcecodedecoratorEditorPlugin() {
        super(new ResourceLocator[] {
                IdentifierEditPlugin.INSTANCE,
                JavaEditPlugin.INSTANCE,
                KdmEditPlugin.INSTANCE,
                PalladioComponentModelEditPlugin.INSTANCE,
                ProbabilityFunctionEditPlugin.INSTANCE,
                StoexEditPlugin.INSTANCE,
                UnitsEditPlugin.INSTANCE,
        });
    }

    /**
     * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static class Implementation extends EclipseUIPlugin {
        /**
         * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        public Implementation() {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }
    }

}
