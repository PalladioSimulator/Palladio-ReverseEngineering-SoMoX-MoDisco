/**
 * Copyright by palladiosimulator.org, 2008-2016
 */
package org.somox.sourcecodedecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmt.modisco.java.Block;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import org.somox.sourcecodedecorator.Seff2MethodLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Seff2 Method Link</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.somox.sourcecodedecorator.impl.Seff2MethodLinkImpl#getBlockstatement
 * <em>Blockstatement</em>}</li>
 * <li>{@link org.somox.sourcecodedecorator.impl.Seff2MethodLinkImpl#getSeff <em>Seff</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Seff2MethodLinkImpl extends EObjectImpl implements Seff2MethodLink {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright by palladiosimulator.org, 2008-2016";

    /**
     * The cached value of the '{@link #getBlockstatement() <em>Blockstatement</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getBlockstatement()
     * @generated
     * @ordered
     */
    protected Block blockstatement;

    /**
     * The cached value of the '{@link #getSeff() <em>Seff</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getSeff()
     * @generated
     * @ordered
     */
    protected ServiceEffectSpecification seff;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected Seff2MethodLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SourceCodeDecoratorPackage.Literals.SEFF2_METHOD_LINK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Block getBlockstatement() {
        if (this.blockstatement != null && this.blockstatement.eIsProxy()) {
            final InternalEObject oldBlockstatement = (InternalEObject) this.blockstatement;
            this.blockstatement = (Block) this.eResolveProxy(oldBlockstatement);
            if (this.blockstatement != oldBlockstatement) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__BLOCKSTATEMENT, oldBlockstatement,
                            this.blockstatement));
                }
            }
        }
        return this.blockstatement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Block basicGetBlockstatement() {
        return this.blockstatement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBlockstatement(final Block newBlockstatement) {
        final Block oldBlockstatement = this.blockstatement;
        this.blockstatement = newBlockstatement;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__BLOCKSTATEMENT, oldBlockstatement,
                    this.blockstatement));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ServiceEffectSpecification getSeff() {
        if (this.seff != null && ((EObject) this.seff).eIsProxy()) {
            final InternalEObject oldSeff = (InternalEObject) this.seff;
            this.seff = (ServiceEffectSpecification) this.eResolveProxy(oldSeff);
            if (this.seff != oldSeff) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__SEFF, oldSeff, this.seff));
                }
            }
        }
        return this.seff;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ServiceEffectSpecification basicGetSeff() {
        return this.seff;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSeff(final ServiceEffectSpecification newSeff) {
        final ServiceEffectSpecification oldSeff = this.seff;
        this.seff = newSeff;
        if (this.eNotificationRequired()) {
            this.eNotify(
                    new ENotificationImpl(this, Notification.SET, SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__SEFF,
                            oldSeff, this.seff));
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
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__BLOCKSTATEMENT:
            if (resolve) {
                return this.getBlockstatement();
            }
            return this.basicGetBlockstatement();
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__SEFF:
            if (resolve) {
                return this.getSeff();
            }
            return this.basicGetSeff();
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
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__BLOCKSTATEMENT:
            this.setBlockstatement((Block) newValue);
            return;
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__SEFF:
            this.setSeff((ServiceEffectSpecification) newValue);
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
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__BLOCKSTATEMENT:
            this.setBlockstatement((Block) null);
            return;
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__SEFF:
            this.setSeff((ServiceEffectSpecification) null);
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
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__BLOCKSTATEMENT:
            return this.blockstatement != null;
        case SourceCodeDecoratorPackage.SEFF2_METHOD_LINK__SEFF:
            return this.seff != null;
        }
        return super.eIsSet(featureID);
    }

} // Seff2MethodLinkImpl
