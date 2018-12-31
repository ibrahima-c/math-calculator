package fr.calculator;

import fr.exceptions.DivisionException;
import fr.exceptions.MathFunctionException;

public interface IMath {

    /**
     * sets the value of an arguments by using its name
     * 
     * @param argName
     * @param value
     */
    void setArgValue( Character argName, Double value );

    /**
     * sets the value of an argument by using its position (argId) in the
     * mathematical expression
     * 
     * @param argId
     * @param value
     */
    void setArgValue( Integer argId, Double value );

    /**
     * 
     * @return The value of the mathematical expression
     * @throws MathFunctionException
     * @throws DivisionException
     */
    Double getValue() throws MathFunctionException, DivisionException;

}
