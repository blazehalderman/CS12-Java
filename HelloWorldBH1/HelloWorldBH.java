/*
* Name:     Blaze Halderman
*
* Course:   CS-12 Fall 2018
*
* Date:     08/22/18
*
* Filename: HelloWorldBH.java
*
* Purpose:  Simple Hello World Java Application to test the language.
*/

public class HelloWorldBH {

    public static void main(String [] args) {

        printGreeting("Blaze", "Halderman");
    }
   
    private static void printGreeting(String firstName, String lastName) {
   
        System.out.println("Hello " + firstName + 
        
                           " " + lastName +
                           
                           ", good to have you in class");  
    }
}
