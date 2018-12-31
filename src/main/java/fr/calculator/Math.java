package fr.calculator;

import java.util.Map;

import fr.exceptions.DivisionException;
import fr.exceptions.MathFunctionException;
import fr.exceptions.ParenthesisException;
import fr.tree.ITree;
import fr.tree.Tree;
import fr.variables.VariableFactory;

public class Math implements IMath {

    private String expression;
    private ITree  tree = new Tree();

    public Math( String expression ) throws ParenthesisException {
        this.expression = expression;
        this.tree.buildTreeFromNodes(
                this.tree.convertFormulaToNodes( this.expression ) );
    }

    @Override
    public void setArgValue( Character argName, Double value ) {
        VariableFactory.getVariable( argName ).setValue( value );
    }

    @Override
    public void setArgValue( Integer argId, Double value ) {

        Character argName = (Character) Math.getKeyFromValue( this.tree.getArgNames(), argId );
        this.setArgValue( argName, value );

    }

    @Override
    public Double getValue() throws MathFunctionException, DivisionException {
        return this.tree.getValue();
    }

    public static Object getKeyFromValue( Map hm, Object value ) {
        for ( Object o : hm.keySet() ) {
            if ( hm.get( o ).equals( value ) ) {
                return o;
            }
        }
        return null;
    }

}
