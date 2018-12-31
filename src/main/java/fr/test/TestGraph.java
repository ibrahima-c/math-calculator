package fr.test;

import fr.exceptions.DivisionException;
import fr.exceptions.MathFunctionException;
import fr.exceptions.ParenthesisException;
import fr.graphs.Graph;
import fr.graphs.IGraph;

public class TestGraph {

    public static void main( String[] args ) {

        IGraph graph;

        Double xmin = 0.0;
        Double xmax = 10.0;
        Integer nbPoints = 1000;

        Double[] xaxis = new Double[nbPoints];
        Double[] Fx = new Double[nbPoints];

        try {
            graph = new Graph( "cos(pi*x)*exp(-x)", xmin, xmax, nbPoints );
            xaxis = graph.getXaxis();
            Fx = graph.getFx();
        } catch ( MathFunctionException | DivisionException | ParenthesisException e ) {
            System.out.println( e.getMessage() );
        }

    }

}
