/**
 */
package org.somox.sourcecodedecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.somox.sourcecodedecorator.PCMSystemImplementatingClassesLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PCM System Implementating Classes Link</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.somox.sourcecodedecorator.impl.PCMSystemImplementatingClassesLinkImpl#getSystemModel
 * <em>System Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PCMSystemImplementatingClassesLinkImpl extends ComponentImplementingClassesLinkImpl
        implements PCMSystemImplementatingClassesLink {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright by palladiosimulator.org, 2008-2016";
    /**
     * The cached value of the '{@link #getSystemModel() <em>System Model</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSystemModel()
     * @generated
     * @ordered
     */
    protected org.palladiosimulator.pcm.system.System systemModel;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMSystemImplementatingClassesLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SourceCodeDecoratorPackage.Literals.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public org.palladiosimulator.pcm.system.System getSystemModel() {
        if (this.systemModel != null && ((EObject) this.systemModel).eIsProxy()) {
            final InternalEObject oldSystemModel = (InternalEObject) this.systemModel;
            this.systemModel = (org.palladiosimulator.pcm.system.System) this.eResolveProxy(oldSystemModel);
            if (this.systemModel != oldSystemModel) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK__SYSTEM_MODEL,
                            oldSystemModel, this.systemModel));
                }
            }
        }
        return this.systemModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public org.palladiosimulator.pcm.system.System basicGetSystemModel() {
        return this.systemModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSystemModel(final org.palladiosimulator.pcm.system.System newSystemModel) {
        final org.palladiosimulator.pcm.system.System oldSystemModel = this.systemModel;
        this.systemModel = newSystemModel;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK__SYSTEM_MODEL, oldSystemModel,
                    this.systemModel));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK__SYSTEM_MODEL:
            if (resolve) {
                return this.getSystemModel();
            }
            return this.basicGetSystemModel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK__SYSTEM_MODEL:
            this.setSystemModel((org.palladiosimulator.pcm.system.System) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK__SYSTEM_MODEL:
            this.setSystemModel((org.palladiosimulator.pcm.system.System) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK__SYSTEM_MODEL:
            return this.systemModel != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMSystemImplementatingClassesLinkImpl
