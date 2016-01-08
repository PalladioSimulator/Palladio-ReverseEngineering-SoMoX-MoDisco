/**
 * Copyright by palladiosimulator.org, 2008-2016
 */
package org.somox.sourcecodedecorator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.modisco.java.Block;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Seff2 Method Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.somox.sourcecodedecorator.Seff2MethodLink#getBlockstatement
 * <em>Blockstatement</em>}</li>
 * <li>{@link org.somox.sourcecodedecorator.Seff2MethodLink#getSeff <em>Seff</em>}</li>
 * </ul>
 *
 * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSeff2MethodLink()
 * @model
 * @generated
 */
public interface Seff2MethodLink extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright by palladiosimulator.org, 2008-2016";

    /**
     * Returns the value of the '<em><b>Blockstatement</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blockstatement</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Blockstatement</em>' reference.
     * @see #setBlockstatement(Block)
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSeff2MethodLink_Blockstatement()
     * @model required="true"
     * @generated
     */
    Block getBlockstatement();

    /**
     * Sets the value of the '{@link org.somox.sourcecodedecorator.Seff2MethodLink#getBlockstatement
     * <em>Blockstatement</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Blockstatement</em>' reference.
     * @see #getBlockstatement()
     * @generated
     */
    void setBlockstatement(Block value);

    /**
     * Returns the value of the '<em><b>Seff</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Seff</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Seff</em>' reference.
     * @see #setSeff(ServiceEffectSpecification)
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#getSeff2MethodLink_Seff()
     * @model required="true"
     * @generated
     */
    ServiceEffectSpecification getSeff();

    /**
     * Sets the value of the '{@link org.somox.sourcecodedecorator.Seff2MethodLink#getSeff
     * <em>Seff</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Seff</em>' reference.
     * @see #getSeff()
     * @generated
     */
    void setSeff(ServiceEffectSpecification value);

} // Seff2MethodLink
