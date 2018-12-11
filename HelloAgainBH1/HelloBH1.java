/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       08/31/18
 *
 * Filename:   HelloBH1.java
 *
 * Purpose:    Utility class component for Hello World.
 */

public class HelloBH1 {

   // instance variables: what the class IS
   private String firstName;
   private String lastName;
   
   // constructor: initializes the class
   public HelloBH1() {
      firstName = "Anonymous";
      lastName = "Student";
   }
   
   // methods: what a class DOES
   
   // prints a greeting given first and last names
   public void printGreeting() {
      System.out.println("Hello " + firstName +
                         " " + lastName +
                         ", good to have you in class.");
   }
   
   // updates the first name
   public void setFirstName(String first) {
      firstName = first;
   }
   
   // updates the last name
   public void setLastName(String last) {
      lastName = last;
   }

}