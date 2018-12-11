/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       010/7/18
 *
 * Filename:   StringsBH1.java
 *
 * Purpose:    manipulating and working with strings
 */

import java.util.Scanner;

public class StringsBH1     {

    public static void main(String [] args)     {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
        Scanner input = new Scanner(System.in);
        String myStr = new String();
        String findString = new String();
        String commaSubString = new String();
        String trimSubString = new String();
        int findIndex;
        int findSubIndex;
        int firstComma;
        int secondComma;
        int thirdComma;
        
        // Computations: computations, algorithms
         
        // prompt for a string variable
        System.out.print("Enter desired string: ");
        myStr = input.nextLine();
         
        // print the string
        System.out.println("1) myStr is:\t" + myStr);
         
        // print the length of the string
        System.out.println("\n2) length of myStr is:\t\t\t\t\t\t\t" + myStr.length());    
    
        // print the first and last characters in the string
        System.out.println("3) first and last chars of myStr are:\t\t\t" + myStr.charAt(0) + " and " + myStr.charAt(myStr.length() - 1));    
    
        // print string in all caps and lowercase compared to regular string
        System.out.println("\n4a) myStr as all caps:\t\t" + myStr.toUpperCase());
        System.out.println("4b) myStr is unchanged:\t\t" + myStr);
        System.out.println("5a) myStr as lower case:\t" + myStr.toLowerCase());
        System.out.println("5b) myStr is unchanged:\t\t" + myStr);
        
        // find a character at a specific index
        System.out.print("Character at which index? > ");
        findIndex = input.nextInt();
        input.nextLine();
        System.out.println("6) char at index 6:\t\t\t\t\t\t" + myStr.charAt(findIndex));
        
        // find a specific string within a string, if not found it will display 0
        System.out.print("\nSearch string to locate? > ");
        findString = input.nextLine();
        System.out.println("\n7) substring " + findString + " is located at index:\t" + myStr.indexOf(findString));
        findSubIndex = myStr.indexOf(findString);
        
        // print substring of starting to end of string
        System.out.println("8) desired substring is:\t\t\t\t" + myStr.substring(findSubIndex, myStr.length()));
        
        // find index of first comma in string
        firstComma = myStr.indexOf(',');
        System.out.println("\n9) first comma is at index:\t\t" + firstComma);
    
        // find index of second comma in string
        secondComma = myStr.indexOf(',', firstComma + 1);
        System.out.println("10) second comma is at index:\t" + secondComma);
        
        // find the index of the third comma in a string
        thirdComma = myStr.indexOf(',', secondComma + 1);
        System.out.println("11) second comma is at index:\t" + thirdComma);
        
        // print substring between comma 2 and comma 3
        commaSubString = myStr.substring(secondComma + 1, thirdComma);
        System.out.println("\n12) between commas 2 and 3 is:\t" + commaSubString + "\tlength = " + commaSubString.length());
    
        // print substring trim between comma 2 and comma 3
        trimSubString = commaSubString.trim();
        System.out.println("13) between commas 2 and 3 is:\t" + trimSubString + "\tlength = " + trimSubString.length());
    }
      
}
