package fr.test;

import fr.calculator.IMath;
import fr.calculator.Math;
import fr.exceptions.DivisionException;
import fr.exceptions.MathFunctionException;
import fr.exceptions.ParenthesisException;

public class TestCalculator {
    public static void main( String[] args ) {

        IMath math;
        Double result = null;

        try {
            math = new Math( "2*x * (2*y+1) + cos(pi*z) " );
            math.setArgValue( 'x', 2.0 );
            math.setArgValue( 'y', 2.0 );
            math.setArgValue( 'z', 1.0 );
            result = math.getValue();
        } catch ( ParenthesisException | MathFunctionException | DivisionException e ) {
            System.out.println( e.getMessage() );
        }

        System.out.println( "The result is " + result );

    }
}
