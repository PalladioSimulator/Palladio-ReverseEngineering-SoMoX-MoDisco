/**
 */
package org.somox.sourcecodedecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmt.modisco.omg.kdm.source.SourceFile;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.somox.sourcecodedecorator.FileLevelSourceCodeLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>File Level Source Code Link</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.somox.sourcecodedecorator.impl.FileLevelSourceCodeLinkImpl#getRepositoryComponent
 * <em>Repository Component</em>}</li>
 * <li>{@link org.somox.sourcecodedecorator.impl.FileLevelSourceCodeLinkImpl#getFile <em>File</em>}
 * </li>
 * </ul>
 *
 * @generated
 */
public class FileLevelSourceCodeLinkImpl extends EObjectImpl implements FileLevelSourceCodeLink {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright by palladiosimulator.org, 2008-2016";

    /**
     * The cached value of the '{@link #getRepositoryComponent() <em>Repository Component</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRepositoryComponent()
     * @generated
     * @ordered
     */
    protected RepositoryComponent repositoryComponent;

    /**
     * The cached value of the '{@link #getFile() <em>File</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getFile()
     * @generated
     * @ordered
     */
    protected SourceFile file;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected FileLevelSourceCodeLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SourceCodeDecoratorPackage.Literals.FILE_LEVEL_SOURCE_CODE_LINK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RepositoryComponent getRepositoryComponent() {
        if (this.repositoryComponent != null && ((EObject) this.repositoryComponent).eIsProxy()) {
            final InternalEObject oldRepositoryComponent = (InternalEObject) this.repositoryComponent;
            this.repositoryComponent = (RepositoryComponent) this.eResolveProxy(oldRepositoryComponent);
            if (this.repositoryComponent != oldRepositoryComponent) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__REPOSITORY_COMPONENT,
                            oldRepositoryComponent, this.repositoryComponent));
                }
            }
        }
        return this.repositoryComponent;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RepositoryComponent basicGetRepositoryComponent() {
        return this.repositoryComponent;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRepositoryComponent(final RepositoryComponent newRepositoryComponent) {
        final RepositoryComponent oldRepositoryComponent = this.repositoryComponent;
        this.repositoryComponent = newRepositoryComponent;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__REPOSITORY_COMPONENT,
                    oldRepositoryComponent, this.repositoryComponent));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SourceFile getFile() {
        if (this.file != null && this.file.eIsProxy()) {
            final InternalEObject oldFile = (InternalEObject) this.file;
            this.file = (SourceFile) this.eResolveProxy(oldFile);
            if (this.file != oldFile) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__FILE, oldFile, this.file));
                }
            }
        }
        return this.file;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SourceFile basicGetFile() {
        return this.file;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFile(final SourceFile newFile) {
        final SourceFile oldFile = this.file;
        this.file = newFile;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__FILE, oldFile, this.file));
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
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__REPOSITORY_COMPONENT:
            if (resolve) {
                return this.getRepositoryComponent();
            }
            return this.basicGetRepositoryComponent();
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__FILE:
            if (resolve) {
                return this.getFile();
            }
            return this.basicGetFile();
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
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__REPOSITORY_COMPONENT:
            this.setRepositoryComponent((RepositoryComponent) newValue);
            return;
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__FILE:
            this.setFile((SourceFile) newValue);
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
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__REPOSITORY_COMPONENT:
            this.setRepositoryComponent((RepositoryComponent) null);
            return;
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__FILE:
            this.setFile((SourceFile) null);
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
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__REPOSITORY_COMPONENT:
            return this.repositoryComponent != null;
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__FILE:
            return this.file != null;
        }
        return super.eIsSet(featureID);
    }

} // FileLevelSourceCodeLinkImpl
