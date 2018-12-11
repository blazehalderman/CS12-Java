/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       08/31/18
 *
 * Filename:   HelloAgainBH1.java
 *
 * Purpose:    Refactored "Hello World" Java application, now uses a utility class.
 */

public class HelloAgainBH1 {

    public static void main(String [] args) {
      
      // create a new object, one specific instance of the class
      HelloBH1 person = new HelloBH1();
      
      // print greeting  for the default person
      person.printGreeting();
      
      // update the object, and print the new greeting
      person.setFirstName("Blaze");
      person.setLastName("Halderman");
      person.printGreeting();
      
    }
      
}
