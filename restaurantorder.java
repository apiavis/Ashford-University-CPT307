/*
 * Title: Queue Practice
 * Author: Alicia Piavis
 * Course: CPT 307 Data Structures, Algorithms, & Design
 * Instructor: Dr. Brenda Holland
 * Date: 11/1/2018
 */

/* 
 * This program utilizes multiple queue 
 * methods in the context of a restaurant,   
 * in which a patron places a food order.
 */

//imports required Java classes
import java.util.LinkedList;
import java.util.Queue;

public class restaurantorder {

    public static void main(String[] args) {
        
        //creates new, empty queue
        Queue<String> restaurantOrder = new LinkedList<>();

	//adds elements to the queue
        restaurantOrder.add("Coke");
	restaurantOrder.add("Caesar Salad");
	restaurantOrder.add("Fettuccini Alfredo");
	restaurantOrder.add("Cheesecake");
		
	//prints the original queue
        System.out.println("Initial Restaurant Order: " + restaurantOrder);

        //returns the element at the head node without removing it
        //(throws exception if queue is empty)	
        System.out.println("The first item in the order is: " + restaurantOrder.element());

        //removes an element from the queue and returns null if empty
        System.out.println(restaurantOrder.poll() + " has been delivered to the table.");

         //a better method for inserting an element into the queue when it may be capacity-restricted
        restaurantOrder.offer("Coffee");
        restaurantOrder.offer("Tiramisu");

        System.out.println("The updated order for the table is: " + restaurantOrder);
		
        //peek returns the element at the head node or “null” if empty
         System.out.println("The next item that needs to be delivered is the: " + restaurantOrder.peek());

    }
    
}
