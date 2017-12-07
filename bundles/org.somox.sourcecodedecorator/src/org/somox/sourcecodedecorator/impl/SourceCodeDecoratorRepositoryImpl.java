/**
 */
package org.somox.sourcecodedecorator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.somox.sourcecodedecorator.FileLevelSourceCodeLink;
import org.somox.sourcecodedecorator.InterfaceSourceCodeLink;
import org.somox.sourcecodedecorator.MethodLevelSourceCodeLink;
import org.somox.sourcecodedecorator.Seff2MethodLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Repository</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.somox.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getFileLevelSourceCodeLink
 * <em>File Level Source Code Link</em>}</li>
 * <li>
 * {@link org.somox.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getMethodLevelSourceCodeLink
 * <em>Method Level Source Code Link</em>}</li>
 * <li>
 * {@link org.somox.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getInterfaceSourceCodeLink
 * <em>Interface Source Code Link</em>}</li>
 * <li>
 * {@link org.somox.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getComponentImplementingClassesLink
 * <em>Component Implementing Classes Link</em>}</li>
 * <li>
 * {@link org.somox.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getSeff2MethodLink
 * <em>Seff2 Method Link</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceCodeDecoratorRepositoryImpl extends EObjectImpl implements SourceCodeDecoratorRepository {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright by palladiosimulator.org, 2008-2016";

    /**
     * The cached value of the '{@link #getFileLevelSourceCodeLink()
     * <em>File Level Source Code Link</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getFileLevelSourceCodeLink()
     * @generated
     * @ordered
     */
    protected EList<FileLevelSourceCodeLink> fileLevelSourceCodeLink;

    /**
     * The cached value of the '{@link #getMethodLevelSourceCodeLink()
     * <em>Method Level Source Code Link</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getMethodLevelSourceCodeLink()
     * @generated
     * @ordered
     */
    protected EList<MethodLevelSourceCodeLink> methodLevelSourceCodeLink;

    /**
     * The cached value of the '{@link #getInterfaceSourceCodeLink()
     * <em>Interface Source Code Link</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getInterfaceSourceCodeLink()
     * @generated
     * @ordered
     */
    protected EList<InterfaceSourceCodeLink> interfaceSourceCodeLink;

    /**
     * The cached value of the '{@link #getComponentImplementingClassesLink()
     * <em>Component Implementing Classes Link</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComponentImplementingClassesLink()
     * @generated
     * @ordered
     */
    protected EList<ComponentImplementingClassesLink> componentImplementingClassesLink;

    /**
     * The cached value of the '{@link #getSeff2MethodLink() <em>Seff2 Method Link</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSeff2MethodLink()
     * @generated
     * @ordered
     */
    protected EList<Seff2MethodLink> seff2MethodLink;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SourceCodeDecoratorRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SourceCodeDecoratorPackage.Literals.SOURCE_CODE_DECORATOR_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<FileLevelSourceCodeLink> getFileLevelSourceCodeLink() {
        if (this.fileLevelSourceCodeLink == null) {
            this.fileLevelSourceCodeLink = new EObjectContainmentEList<FileLevelSourceCodeLink>(
                    FileLevelSourceCodeLink.class, this,
                    SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILE_LEVEL_SOURCE_CODE_LINK);
        }
        return this.fileLevelSourceCodeLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<MethodLevelSourceCodeLink> getMethodLevelSourceCodeLink() {
        if (this.methodLevelSourceCodeLink == null) {
            this.methodLevelSourceCodeLink = new EObjectContainmentEList<MethodLevelSourceCodeLink>(
                    MethodLevelSourceCodeLink.class, this,
                    SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHOD_LEVEL_SOURCE_CODE_LINK);
        }
        return this.methodLevelSourceCodeLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<InterfaceSourceCodeLink> getInterfaceSourceCodeLink() {
        if (this.interfaceSourceCodeLink == null) {
            this.interfaceSourceCodeLink = new EObjectContainmentEList<InterfaceSourceCodeLink>(
                    InterfaceSourceCodeLink.class, this,
                    SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__INTERFACE_SOURCE_CODE_LINK);
        }
        return this.interfaceSourceCodeLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ComponentImplementingClassesLink> getComponentImplementingClassesLink() {
        if (this.componentImplementingClassesLink == null) {
            this.componentImplementingClassesLink = new EObjectContainmentEList<ComponentImplementingClassesLink>(
                    ComponentImplementingClassesLink.class, this,
                    SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__COMPONENT_IMPLEMENTING_CLASSES_LINK);
        }
        return this.componentImplementingClassesLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Seff2MethodLink> getSeff2MethodLink() {
        if (this.seff2MethodLink == null) {
            this.seff2MethodLink = new EObjectContainmentEList<Seff2MethodLink>(Seff2MethodLink.class, this,
                    SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__SEFF2_METHOD_LINK);
        }
        return this.seff2MethodLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILE_LEVEL_SOURCE_CODE_LINK:
            return ((InternalEList<?>) this.getFileLevelSourceCodeLink()).basicRemove(otherEnd, msgs);
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHOD_LEVEL_SOURCE_CODE_LINK:
            return ((InternalEList<?>) this.getMethodLevelSourceCodeLink()).basicRemove(otherEnd, msgs);
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__INTERFACE_SOURCE_CODE_LINK:
            return ((InternalEList<?>) this.getInterfaceSourceCodeLink()).basicRemove(otherEnd, msgs);
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__COMPONENT_IMPLEMENTING_CLASSES_LINK:
            return ((InternalEList<?>) this.getComponentImplementingClassesLink()).basicRemove(otherEnd, msgs);
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__SEFF2_METHOD_LINK:
            return ((InternalEList<?>) this.getSeff2MethodLink()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILE_LEVEL_SOURCE_CODE_LINK:
            return this.getFileLevelSourceCodeLink();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHOD_LEVEL_SOURCE_CODE_LINK:
            return this.getMethodLevelSourceCodeLink();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__INTERFACE_SOURCE_CODE_LINK:
            return this.getInterfaceSourceCodeLink();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__COMPONENT_IMPLEMENTING_CLASSES_LINK:
            return this.getComponentImplementingClassesLink();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__SEFF2_METHOD_LINK:
            return this.getSeff2MethodLink();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILE_LEVEL_SOURCE_CODE_LINK:
            this.getFileLevelSourceCodeLink().clear();
            this.getFileLevelSourceCodeLink().addAll((Collection<? extends FileLevelSourceCodeLink>) newValue);
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHOD_LEVEL_SOURCE_CODE_LINK:
            this.getMethodLevelSourceCodeLink().clear();
            this.getMethodLevelSourceCodeLink().addAll((Collection<? extends MethodLevelSourceCodeLink>) newValue);
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__INTERFACE_SOURCE_CODE_LINK:
            this.getInterfaceSourceCodeLink().clear();
            this.getInterfaceSourceCodeLink().addAll((Collection<? extends InterfaceSourceCodeLink>) newValue);
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__COMPONENT_IMPLEMENTING_CLASSES_LINK:
            this.getComponentImplementingClassesLink().clear();
            this.getComponentImplementingClassesLink()
                    .addAll((Collection<? extends ComponentImplementingClassesLink>) newValue);
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__SEFF2_METHOD_LINK:
            this.getSeff2MethodLink().clear();
            this.getSeff2MethodLink().addAll((Collection<? extends Seff2MethodLink>) newValue);
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
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILE_LEVEL_SOURCE_CODE_LINK:
            this.getFileLevelSourceCodeLink().clear();
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHOD_LEVEL_SOURCE_CODE_LINK:
            this.getMethodLevelSourceCodeLink().clear();
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__INTERFACE_SOURCE_CODE_LINK:
            this.getInterfaceSourceCodeLink().clear();
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__COMPONENT_IMPLEMENTING_CLASSES_LINK:
            this.getComponentImplementingClassesLink().clear();
            return;
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__SEFF2_METHOD_LINK:
            this.getSeff2MethodLink().clear();
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
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILE_LEVEL_SOURCE_CODE_LINK:
            return this.fileLevelSourceCodeLink != null && !this.fileLevelSourceCodeLink.isEmpty();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHOD_LEVEL_SOURCE_CODE_LINK:
            return this.methodLevelSourceCodeLink != null && !this.methodLevelSourceCodeLink.isEmpty();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__INTERFACE_SOURCE_CODE_LINK:
            return this.interfaceSourceCodeLink != null && !this.interfaceSourceCodeLink.isEmpty();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__COMPONENT_IMPLEMENTING_CLASSES_LINK:
            return this.componentImplementingClassesLink != null && !this.componentImplementingClassesLink.isEmpty();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__SEFF2_METHOD_LINK:
            return this.seff2MethodLink != null && !this.seff2MethodLink.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // SourceCodeDecoratorRepositoryImpl
