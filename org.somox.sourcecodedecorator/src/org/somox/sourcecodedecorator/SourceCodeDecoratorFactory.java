/**
 */
package org.somox.sourcecodedecorator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage
 * @generated
 */
public interface SourceCodeDecoratorFactory extends EFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright by palladiosimulator.org, 2008-2016";
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    SourceCodeDecoratorFactory eINSTANCE = org.somox.sourcecodedecorator.impl.SourceCodeDecoratorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>File Level Source Code Link</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>File Level Source Code Link</em>'.
     * @generated
     */
    FileLevelSourceCodeLink createFileLevelSourceCodeLink();

    /**
     * Returns a new object of class '<em>Method Level Source Code Link</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Method Level Source Code Link</em>'.
     * @generated
     */
    MethodLevelSourceCodeLink createMethodLevelSourceCodeLink();

    /**
     * Returns a new object of class '<em>Repository</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Repository</em>'.
     * @generated
     */
    SourceCodeDecoratorRepository createSourceCodeDecoratorRepository();

    /**
     * Returns a new object of class '<em>Interface Source Code Link</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Interface Source Code Link</em>'.
     * @generated
     */
    InterfaceSourceCodeLink createInterfaceSourceCodeLink();

    /**
     * Returns a new object of class '<em>Component Implementing Classes Link</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Component Implementing Classes Link</em>'.
     * @generated
     */
    ComponentImplementingClassesLink createComponentImplementingClassesLink();

    /**
     * Returns a new object of class '<em>PCM System Implementating Classes Link</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>PCM System Implementating Classes Link</em>'.
     * @generated
     */
    PCMSystemImplementatingClassesLink createPCMSystemImplementatingClassesLink();

    /**
     * Returns a new object of class '<em>Seff2 Method Link</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return a new object of class '<em>Seff2 Method Link</em>'.
     * @generated
     */
    Seff2MethodLink createSeff2MethodLink();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    SourceCodeDecoratorPackage getSourceCodeDecoratorPackage();

} // SourceCodeDecoratorFactory
