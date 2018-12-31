package fr.graphs;

import fr.tree.ITree;

public interface IGraph {

    /**
     * 
     * @return The x-axis range in an array of double
     */
    Double[] getXaxis();

    /**
     * 
     * @return the values of the mathematical expression in an array of double
     */
    Double[] getFx();

    /**
     * 
     * @return the tree built from the mathematical expression
     */
    ITree getTree();

}
