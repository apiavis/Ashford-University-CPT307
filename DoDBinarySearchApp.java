/*
 * Title: DoD Binary Search App
 * Author: Alicia Piavis
 * Course: CPT 307 Data Structures, Algorithms, & Design
 * Instructor: Dr. Brenda Holland
 * Date: 10/29/2018
 */

/* This program utilizes a binary search algorithm 
 * to search a given array for values entered   
 * as input by a user, in order to simulate
 * a project specification as a Junior Software 
 * developer at the DoD.
 */

package dodbinarysearchapp;
//imports Java libraries
import java.util.Scanner;
import java.util.Arrays;

public class DoDBinarySearchApp 
{
    //defines function that performs binary search 
    public static int binarySearch(int[] arr, int arrayLength, int searchValue) 
    {
        //variables for the binary search are initialized
        int mid = 0;
        int low = 0;
        int high = arrayLength - 1;
        
        //loop that checks conditions to perform the binary search
        while (high >= low) 
        {
            mid = (high + low) / 2;
            if (arr[mid] < searchValue) 
            {
                low = mid + 1;
            }
            else if (arr[mid] > searchValue) 
            {
                high = mid - 1;
            }
            else 
            {
                //returns the index of the located search value
                return mid;
            }
        }
        //value not found
        return -1;
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) 
    {
        //variables are declared and assigned
        boolean boolRepeat = true;
        String inputAskRepeat = null;
        int searchValue = 0; 
        int i = 0;
        int keyIndex = 0;
        
        //Scanner class is utilized to receive keyboard input
        Scanner Keystrokes = new Scanner(System.in);
        Scanner Keystrokes2 = new Scanner(System.in);
        
        //hard codes array
        int[] unsortedArr = {5,10,15,20,25,30,35,40,45,50,55,60,65,70};

        //sorts the array if unsorted
        int arr[];
        Arrays.sort(unsortedArr);
        arr = unsortedArr;
        //calculates the number of elements in the array
        int arrayLength = arr.length;
        
        //prints prompt for beginning of application
        System.out.println("---------------------------");
        System.out.println("DoD Binary Search App");
        System.out.println("---------------------------");
        
        //iterates over the sorted array to print all of the values 
        System.out.println("Sorted Array: ");
        System.out.println();        
        for (i = 0; i < arrayLength; ++i) {
            System.out.print(arr[i]);
            System.out.print(" ");            
        }        
        
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------");        
        
        //beginning of "while" loop that allows the application to run continuously
        while (boolRepeat == true)
        {
            boolean searchAgain = true;
            
            //requests input for search value
            System.out.print("Please enter the value you would like to search for: ");
            searchValue = Keystrokes.nextInt();
            System.out.println();
        
            //calls the binarySearch function
            keyIndex = binarySearch(arr, arrayLength, searchValue);
        
            //checks condition after binary search to determine whether or not value was found
            if (keyIndex == -1)
            {
                System.out.println(searchValue + " was not found.");
                System.out.println();                
                System.out.println("-------------------------------------------------------");
            }
            else
            {                
                System.out.println("Found " + searchValue + " at index " + keyIndex + ".");
                System.out.println();                
                System.out.println("-------------------------------------------------------");                
            }
            
            //"while" loop that asks user whether or not they want to search again
            while (searchAgain == true)
            {
                System.out.println();                
                //asks user if they want to run the program again
                System.out.print("Search for another value? (Y or N): ");

                //takes input from user and converts to lower case character and trims white space
                inputAskRepeat = Keystrokes2.nextLine(); 
                inputAskRepeat = inputAskRepeat.toLowerCase().trim();              
                
                //branch which causes loop to continue or exit
                if (inputAskRepeat.charAt(0) == "n".charAt(0))
                {                    
                    searchAgain = false;
                    boolRepeat = false;
                    System.out.println();                
                    System.out.println("-------------------------------------------------------");                    
                }
                else if (inputAskRepeat.charAt(0) == "y".charAt(0))
                {                   
                    searchAgain = false;
                    boolRepeat = true;
                    System.out.println();                
                    System.out.println("-------------------------------------------------------");
                    System.out.println();                      
                }
                else 
                {    
                    searchAgain = true;
                    System.out.println();                
                    System.out.println("-------------------------------------------------------");                    
                }    
            }    
        }       
        //end of the program if user doe not want to search another value
        System.out.print("\nProgram terminated...");        
    }
    
}
