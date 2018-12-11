/*
 * Name:       Rob Lapkass
 *
 * Course:     CS-12, Fall 2018
 *
 * Date:       11/04/18
 *
 * Filename:   DamTest1RL.java
 *
 * Purpose:    Test program for student Dam class, this is just for first week's tests.
 *             This file MUST be able to run standalone in a fresh directory.
 *
 *             STUDENT SHOULD NOT SIMPLY COPY-PASTE THIS CODE AS THEIR OWN TEST CODE!
 *             Use this code as a guideline, but write your OWN test code from scratch in your Dam!
 *
 *             INSTRUCTIONS: change all instances of DamBH1 --> DamFL by doing a global find-replace,
 *             then run this file and *carefully inspect* all incremental results
 *             The program will incrementally pause to let you do that.
 */

import java.util.Scanner;

public class DamTest1RL {

   // main method is the unit test code/driver for this class
   // this code will be used to test student Dam class
   
   public static void main(String [] args) {
   
      // these will be our tester dams
      DamBH1 testDam, defaultDam;
      
      String testStr;
      CS12Date testDate;
      
      message("Week 12 unit test code for class DamBH1", true);
      message("Do NOT copy-paste this as your own test code!", false);
      message("Use this as a GUIDE, but write your OWN test code from scratch as you develop your Dam class.\n", false);
   
      // test all constructor forms ---------------------------------    
      message("Testing all 4 constructor forms... use toString() AND overloaded print() to display...\n", false);    
      
      // test default constructor
      testDam = new DamBH1();
      System.out.println("toString(): " + testDam);  // use toString()
      testDam.print("dam created from default constructor: make sure ALL defaults except year are 0.0, date is TODAY");
      pause();
      
      // test full constructor
      testDam = new DamBH1("dam 2", 1963, 500000, 1000000, 200, 100, new CS12Date(1, 1, 2000));
      System.out.println("toString(): " + testDam);  // use toString()
      testDam.print("dam created from full constructor: make sure ALL values as specified by designer");
      pause();

      // test name-year constructor
      testDam = new DamBH1("dam 3", 1986);
      System.out.println("toString(): " + testDam);  // use toString()
      testDam.print("dam created from name/year constructor: should show ALL defaults EXCEPT name/year");
      pause();
      
      // test name-capacity constructor
      testDam = new DamBH1("dam 4", 100000.0);
      System.out.println("toString(): " + testDam);  // use toString()
      testDam.print("dam created from name/capacity constructor: should show ALL defaults EXCEPT name/capacity");
      pause();
      
      //-----------------------------------
      
      // test all accessors and mutators --------------------------- 
      message("Testing all accessors and mutators...", true);
      message("Prompt for each instance variable using its prompting set(), which uses set() internally\n" +
              "then echo it back out using its get()\n", false);
      
      // default dam
      testDam = new DamBH1();
      testDam.print("Starting point is a new default DamBH1");
      pause();
      
      // name set/get
      testDam.setName(false);
      message("get: name should be set to:\t\t" + testDam.getName() + "\n", false);
      
      // year set/get
      testDam.setYear(false);
      message("get: year should be set to:\t\t" + testDam.getYear() + "\n", false);
      
      // date set/get
      testDam.setDate(false);
      testDam.setDate(testDam.getDate());  // this extra check ensures there is no 3-input setDate!
      message("get: date should be set to:\t\t" + testDam.getDate() + "\n", false);
      
      // storage set/get
      testDam.setStorage(false);
      message("get: storage should be set to:\t" + testDam.getStorage() + "\n", false);
      
      // capacity set/get
      testDam.setCapacity(false);
      message("get: capacity should be set to:\t" + testDam.getCapacity() + "\n", false);
        
      // inflow set/get
      testDam.setInflow(false);
      message("get: inflow should be set to:\t" + testDam.getInflow() + "\n", false);
      
      // outflow set/get
      testDam.setOutflow(false);
      message("get: outflow should be set to:\t" + testDam.getOutflow() + "\n", false);
      
      // final dam state
      testDam.print("Updated dam state should reflect all above changes:");
      pause();

      //-----------------------------------
      
      // test equality ----------------------------------------------
      message("Testing for equality...", true);      
      
      // same dam
      message("Any Dam should equal itself:\t\t\t\t" + testDam.equals(testDam), false);
    
      // different dams
      defaultDam = new DamBH1();
      message("Any two DIFFERENT Dams should NOT be equal:\t" + testDam.equals(defaultDam), false);
      
      // against other objects
      testStr = "test string";
      testDate = new CS12Date();
      message("A Dam and a String should NOT be equal:\t\t" + testDam.equals(testStr), false);
      message("A Dam and a CS12Date should NOT be equal:\t" + testDam.equals(testDate), false);
      
      message("", false);
      message("End Week 12 unit test code for class DamBH1", true);
           
   } // end main
  
   //-------------------------------------------------------------------------------------------------------------
   
   //------------------------------------------------------------------------------------
   // You may feel free to add these methods, or ones similar to these, to your own Utils
   // (just make yours public not private)
   //------------------------------------------------------------------------------------
   
   // display related methods -------------------------------------------------
   
   // utility method which prints a specified spacer character N times
   private static void spacer(char ch, int n) {
      for (int i=0; i < n; i++) {
         System.out.print(ch);
      }
      System.out.println();
   }
   
   // overloaded default spacer, 40 chars of '='
   private static void spacer() {
       spacer('=', 40);
   }
   
   // print a message with or without surrounding bounding box
   private static void message(String msg, boolean box) {
      if (!box) {
         System.out.println(msg);
      }
      else {
         spacer('=', msg.length());
         System.out.println(msg);
         spacer('=', msg.length());
      }
   }

   // overloaded default version, just a shortcut to printing a bounded message
   private static void message(String msg) {
      message(msg, true);
   }
   
   // execution related methods ------------------------------------------------
    
   // pauses execution until any key is pressed, specific prompt
   private static void pause(String message) {
      // ignores any returned value
      readString(message);    // update with own Utils version if desired, but add boolean input
      System.out.println();   // add a blank line
   }
    
   // pauses execution until any key is pressed, generic prompt
   private static void pause() {
      pause("Press <Enter> to continue... ");
   }
    
   // get a String value (standalone, cmd-line only version)
   // update with own Utils version if desired, but add boolean input in above method call
   private static String readString(String prompt) {
    
      // set up data and objects
      String data;
      Scanner input = new Scanner(System.in);

      System.out.print(prompt);
      data = input.nextLine();
      
      return data;
   }
	 	 
} // end class