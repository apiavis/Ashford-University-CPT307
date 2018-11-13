/*
 * Title: Car Tree Java App
 * Author: Alicia Piavis (modified from 
 * http://www.quesucede.com/page/show/id/java-tree-implementation#app-class
 * Copyright (C) 2007-2014 by Brett Alistair Kromkamp <brett@perfectlearn.com>)
 * Course: CPT 307 Data Structures, Algorithms, & Design
 * Instructor: Dr. Brenda Holland
 * Date: 11/10/2018
 */

/* This application builds a tree ADT in Java 
 * and then traverses the tree utilizing    
 * depth first and breadth first iterations.
 * The only modifications to the original code
 * are the nodes in the tree (changed from names to car
 * brand owners, manufacturers, makes, and models).
 * Some new code comments were added to the original code 
 * comments written by Brett Alistair Kromkamp (BAK).
 */

package cartreejavaapp;

import java.util.Iterator;

public class CarTreeJavaApp {

    public static void main(String[] args) {
        Tree tree = new Tree();

        /*
         * The second parameter for the addNode method is the identifier
         * for the node's parent. In the case of the root node, either
         * null is provided or no second parameter is provided (BAK).
         */
        tree.addNode("Exor");
        tree.addNode("Fiat Chrysler", "Exor");
        tree.addNode("Ferrari", "Exor");
        tree.addNode("Alfa Romeo", "Fiat Chrysler");
        tree.addNode("Fiat", "Fiat Chrysler");
        tree.addNode("Maserati", "Fiat Chrysler");
        tree.addNode("California", "Ferrari");
        tree.addNode("Enzo", "Ferrari");
        tree.addNode("LaFerrari", "Ferrari");
        tree.addNode("Sportiva", "Alfa Romeo");
        tree.addNode("Spider Duetto", "Alfa Romeo");
        tree.addNode("500", "Fiat");
        tree.addNode("500L", "Fiat");
        tree.addNode("Quattroporte", "Maserati");
        tree.addNode("GrantTurismo", "Maserati");

        // Displays the tree
        tree.display("Exor");
        
        // Prints header
        System.out.println("");
        System.out.println("***** DEPTH-FIRST ITERATION *****");

        // Default traversal strategy is 'depth-first' (BAK)
        Iterator<Node> depthIterator = tree.iterator("Exor");

        // Iterates over the nodes of the tree (references Node class)
        while (depthIterator.hasNext()) {
            Node node = depthIterator.next();
            System.out.println(node.getIdentifier());
        }

        //Prints header
        System.out.println("");
        System.out.println("***** BREADTH-FIRST ITERATION *****");

        /* Iterates over nodes in the tree 
         * (references TraversalStrategy,
         * Tree, and BreadthFirstIterator classes)
        */
        Iterator<Node> breadthIterator = tree.iterator("Exor", TraversalStrategy.BREADTH_FIRST);

        while (breadthIterator.hasNext()) {
            Node node = breadthIterator.next();
            System.out.println(node.getIdentifier());
        }
        
    }
    
}
