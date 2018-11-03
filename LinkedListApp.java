/*
 * Title: DoD Linked List App
 * Author: Alicia Piavis
 * Course: CPT 307 Data Structures, Algorithms, & Design
 * Instructor: Dr. Brenda Holland
 * Date: 11/3/2018
 */

/* This program utilizes linked list methods 
 * to add elements to an empty list,   
 * insert a new element at a specific index,
 * remove an element at a specific index, 
 * and print the contents of the linked list.
 */

package linkedlistapp;
//import required Java classes
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class LinkedListApp {

    public static void main(String[] args) {
    
        //declare and assigns variables
        int addElementIndex = 0;
        int index = 0;
        String addElement = null;
        int removeElementIndex = 0;
        Scanner keyboard = new Scanner(System.in);
        
        //creates new linked list for string data
        LinkedList<String> cars = new LinkedList<String>();
        
        //add elements to the linked list
        cars.add("Ferarri");
        cars.add("Bugatti");
        cars.add("Lamborghini");
        cars.add("Lotus");
        cars.add("McLaren");
        
        //prints Application Header
        System.out.println("---------------------------");
        System.out.println("Linked List App");
        System.out.println("---------------------------");
        System.out.println();

        //prints contents of the original linked list
        System.out.println("Original Linked List: " + cars);
        System.out.println();
        
        //asks user where they would like to insert a new element
        System.out.print("At what index would you like to add a new element (0-5)?: ");
        addElementIndex = keyboard.nextInt();
        System.out.println();
        
        //asks the user what element they would like to add to the linked list
        System.out.print("Which element would you like to add at index " + 
        addElementIndex + "?: ");
        addElement = keyboard.next();
        System.out.println();
                
        //adds the new element at the desired index
        cars.add(addElementIndex, addElement);
        
        //prints updated contents of list
        System.out.println("Modified Linked List: " + cars);
        System.out.println();
        
        //asks the user which element they would like to remove based on index
        System.out.print("At which index would you like to remove an element (0-5)?: ");        
        removeElementIndex = keyboard.nextInt();
        System.out.println();
        
        //removes element at selected index
        cars.remove(removeElementIndex);

        //prints final contents of linked list
        System.out.println("Final Linked List: " + cars);    
        System.out.println();
        System.out.println("Thank you.  Program Terminated.");
    }
    
}
