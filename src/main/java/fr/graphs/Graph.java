package fr.graphs;

import fr.exceptions.DivisionException;
import fr.exceptions.MathFunctionException;
import fr.exceptions.ParenthesisException;
import fr.tree.ITree;
import fr.tree.Tree;
import fr.variables.VariableFactory;

public class Graph implements IGraph {

    private Double   xmin;
    private Double   xmax;
    private Integer  nbPoints;
    private String   expression;

    private ITree    tree;

    private Double[] xaxis;
    private Double[] Fx;
    private Double   ymin;
    private Double   ymax;

    public Graph( String expression, Double xmin, Double xmax, Integer nbPoints )
            throws MathFunctionException, DivisionException, ParenthesisException {
        this.xmin = xmin;
        this.xmax = xmax;
        this.nbPoints = nbPoints;
        this.expression = expression;
        this.setXaxis();
        this.setTree();
        this.setFx();
    }

    private void setFx() throws MathFunctionException, DivisionException {
        this.Fx = new Double[this.nbPoints];
        for ( int i = 0; i < this.nbPoints; i++ ) {
            VariableFactory.getVariable( 'x' ).setValue( xaxis[i] );
            Fx[i] = this.tree.getValue();
        }
    }

    private void setTree() throws ParenthesisException {
        tree = new Tree();
        tree.buildTreeFromNodes(
                tree.convertFormulaToNodes( this.expression ) );
    }

    private void setXaxis() {
        this.xaxis = new Double[this.nbPoints];
        for ( int i = 0; i < this.nbPoints; i++ )
            this.xaxis[i] = this.xmin + ( this.xmax - this.xmin ) * i / ( this.nbPoints - 1 );
    }

    public ITree getTree() {
        return tree;
    }

    public Double getXmin() {
        return xmin;
    }

    public void setXmin( Double xmin ) {
        this.xmin = xmin;
    }

    public Double getXmax() {
        return xmax;
    }

    public void setXmax( Double xmax ) {
        this.xmax = xmax;
    }

    public Integer getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints( Integer nbPoints ) {
        this.nbPoints = nbPoints;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression( String expression ) {
        this.expression = expression;
    }

    public Double[] getXaxis() {
        return xaxis;
    }

    public Double[] getFx() {
        return Fx;
    }

    public Double getYmin() {
        return ymin;
    }

    public Double getYmax() {
        return ymax;
    }

}
