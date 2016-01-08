/**
 */
package org.somox.sourcecodedecorator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Repository</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.somox.sourcecodedecorator.SourceCodeDecoratorRepository#getFileLevelSourceCodeLink
 * <em>File Level Source Code Link</em>}</li>
 * <li>
 * {@link org.somox.sourcecodedecorator.SourceCodeDecoratorRepository#getMethodLevelSourceCodeLink
 * <em>Method Level Source Code Link</em>}</li>
 * <li>{@link org.somox.sourcecodedecorator.SourceCodeDecoratorRepository#getInterfaceSourceCodeLink
 * <em>Interface Source Code Link</em>}</li>
 * <li>
 * {@link org.somox.sourcecodedecorator.SourceCodeDecoratorRepository#getComponentImplementingClassesLink
 * <em>Component Implementing Classes Link</em>}</li>
 * <li>{@link org.somox.sourcecodedecorator.SourceCodeDecoratorRepository#getSeff2MethodLink
 * <em>Seff2 Method Link</em>}</li>
 * </ul>
 *
 * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSourceCodeDecoratorRepository()
 * @model
 * @generated
 */
public interface SourceCodeDecoratorRepository extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright by palladiosimulator.org, 2008-2016";

    /**
     * Returns the value of the '<em><b>File Level Source Code Link</b></em>' containment reference
     * list. The list contents are of type
     * {@link org.somox.sourcecodedecorator.FileLevelSourceCodeLink}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Level Source Code Link</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>File Level Source Code Link</em>' containment reference list.
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSourceCodeDecoratorRepository_FileLevelSourceCodeLink()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<FileLevelSourceCodeLink> getFileLevelSourceCodeLink();

    /**
     * Returns the value of the '<em><b>Method Level Source Code Link</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.somox.sourcecodedecorator.MethodLevelSourceCodeLink}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Method Level Source Code Link</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Method Level Source Code Link</em>' containment reference list.
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSourceCodeDecoratorRepository_MethodLevelSourceCodeLink()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<MethodLevelSourceCodeLink> getMethodLevelSourceCodeLink();

    /**
     * Returns the value of the '<em><b>Interface Source Code Link</b></em>' containment reference
     * list. The list contents are of type
     * {@link org.somox.sourcecodedecorator.InterfaceSourceCodeLink}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface Source Code Link</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Interface Source Code Link</em>' containment reference list.
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSourceCodeDecoratorRepository_InterfaceSourceCodeLink()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<InterfaceSourceCodeLink> getInterfaceSourceCodeLink();

    /**
     * Returns the value of the '<em><b>Component Implementing Classes Link</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.somox.sourcecodedecorator.ComponentImplementingClassesLink}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Component Implementing Classes Link</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Component Implementing Classes Link</em>' containment reference
     *         list.
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSourceCodeDecoratorRepository_ComponentImplementingClassesLink()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<ComponentImplementingClassesLink> getComponentImplementingClassesLink();

    /**
     * Returns the value of the '<em><b>Seff2 Method Link</b></em>' containment reference list. The
     * list contents are of type {@link org.somox.sourcecodedecorator.Seff2MethodLink}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Seff2 Method Link</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Seff2 Method Link</em>' containment reference list.
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSourceCodeDecoratorRepository_Seff2MethodLink()
     * @model containment="true"
     * @generated
     */
    EList<Seff2MethodLink> getSeff2MethodLink();

} // SourceCodeDecoratorRepository
