/*
 * Name:         Rob Lapkass
 *
 * Course:       CS-12, Fall 2018
 *
 * Date:         11/11/18
 *
 * Filename:     DamTest2.java
 *
 * Purpose:      Revised version of Dam II test code, with tests in modular format by methods.
 *               User is now able to select specific tests for execution.
 *
 * Instructions: IMPORTANT: *First* make sure there are "stub" methods for ALL required API method interfaces.
 *               Even if the methods are not implemented yet and the results are all wrong,
 *               this test code MUST still be able to compile and run. 
 *               Check against this test code frequently while writing your code!
 * 
 *               void methods (x5) return no value
 *               int methods (x2) can return a 0 for now
 *               double method (x1) can return a 0.0 for now
 *               CS12Date method (x1) can return a default C12Date for now
 *               String method (x1) can return some bogus string for now
 *         
 *               Then, this code will compile against the API, and you can
 *               iteratively run it as you develop and test each of the new methods.
 *
 *               1) Implement placeholder methods for ALL 10 *added* API methods (see above)
 *               2) Change DamBH1 --> DamFL, by doing global find-replace (Ctrl-F)
 *               3) Change UtilsBH1 --> UtilsFL, by doing global find-replace (Ctrl-F)
 *               4) Compile and make sure there no errors, missing methods, API is satisfied fully
 *               5) Then, run this program, select various options, and carefully inspect results!
 */

import java.util.Scanner;

public class DamTest2RL {

    // these values are used multiply within this file
    // this is the ONLY reason these are "global" as shown here
    final static CS12Date TODAY = UtilsBH1.today();
    final static CS12Date MEAS_DATE = new CS12Date(11, 10, 2018);  // measurement date
    final static int TEST_YEAR = TODAY.getYear();  // might want this as another years?
    final static double TEST_CAPACITY = 1000000.0; // for most cases
    final static double TEST_CAPACITY2 = 1500000.0; // for F test specifically, to see 33.3%
    final static double TEST_STORAGE = 500000.0;
    final static double TEST_INFLOW = 1000.0;
    final static double TEST_OUTFLOW = 2000.0;
    
    public static void main(String [] args) {
   
        // input option and reusable menu
        char option;
        String menu = "-----------------------\n" +
                      "Dam Method Test Options\n" +
                      "-----------------------\n" +
                      " 1) Dam display format tests        [F]\n" +
                      " 2) Dam derived data tests          [D]\n" + 
                      " 3) Dam numeric tests x4            [N]\n" +
                      " 4) Dam holding test                [H]\n" +
                      "---------------------------------------\n" +
                      " 5) Dam update() test               [U]\n" + 
                      " 6) Dam water utils tests           [W]\n" + 
                      "---------------------------------------\n" +
                      " 7) Dam mutator data checking tests [M]\n" +
                      " 8) Dam date data safe tests        [S]\n" +
                      " 9) Dam constructors bad data tests [C]\n" +
                      "10) Dam water utils bad data tests  [B]\n" +
                      "---------------------------------------\n" +
                      "Quit                                [Q]\n" +
                      "Enter option: ";
        
        // main program loop
        do  {
        
            // priming read
            option = UtilsBH1.readChar(menu, false);
            
            // switch on options from above read
            switch (option) {
            
                case 'F':
                case 'f':
                    // test display method output formatting
                    runDamDisplayFormatTest();
                    break;
                    
                case 'D':
                case 'd':
                    // test derived data accessors
                    runDamDerivedDataTests();
                    break;
                    
                case 'N':
                case 'n':
                    // test dam numeric computations
                    runDamNumericTests();
                    break;
                    
                case 'H':
                case 'h':
                    // test a "holding" case dam
                    runDamHoldingTest();
                    break;
                    
                case 'U':
                case 'u':
                    // test update() method
                    runDamUpdateTest();
                    break;
                
                case 'W':
                case 'w':
                    // test nominal water utilities usage
                    runDamWaterUtilsNominalTests();
                    break;
                    
                case 'M':
                case 'm':
                    // test mutator data checking
                    runDamMutatorDataCheckingTests();
                    break;
                    
                case 'S':
                case 's':
                    // test date-safe data handling
                    runDamDateDataSafeTests();
                    break;
                    
                case 'C':
                case 'c':
                    // test bad data in constructors
                    runDamConstructorsBadDataTests();
                    break;
                    
                case 'B':
                case 'b':
                    // test bad data in water utilities
                    runDamWaterUtilsBadDataTests();
                    break;
                    
                case 'Q':
                case 'q':
                    // program termination
                    System.out.println("\nTerminating upon user request!");
                    break;
                    
                default:
                    // all unrecognized options
                    System.out.println("Unrecognized option " + option + ", please try again\n");
                    break;
                    
            } // end switch
            
        } while ((option != 'Q') && (option != 'q'));         
                 
    } // end main
    
    //========================================================================================

    // dam display method format tests [F]
    private static void runDamDisplayFormatTest() {
        DamBH1 test = new DamBH1("test dam", 1900, 
                               TEST_STORAGE, TEST_CAPACITY2, TEST_INFLOW, TEST_OUTFLOW, 
                               MEAS_DATE);  // use specific capacity to force 33.3%
        DamBH1 def = new DamBH1();
                             
        header("Dam Display Format Tests",
               "checks numerical formatting of toString() and print()",
               "output formats should match those shown in sample outputs",
               "toString() and print() format specifiers");
        
        message("toString(): want to see space-separated data, ONLY 7 instance vars", false);
        message("print(): want to see neatly aligned RHS data", false);        
        message("water data: want to see 3-place commas, no decimals", false);
        message("pct full: want to see 1-place decimal, trailing pct sign", false);
        message("event days: whole number value", false);
        message("event date: NOT today's date", false);
        blank();
        
        // test toString()
        System.out.println(test);
        // test print()
        test.print("test dam");
        pause();
        
    }

    //---------------------------------------------------------------------------
    
    // derived data accessor test [D]
    private static void runDamDerivedDataTests() {
    
        DamBH1 test = new DamBH1("starting dam", TEST_YEAR,
                               TEST_STORAGE, TEST_CAPACITY2,
                               TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
                               
        header("Dam Derived Data Accessor Tests",
               "show a TEST dam, call derived data accessors directly",
               "all derived data accessors can be called directly per API",
               "the 5 new derived data accessors, getXXXX()");
        blank();
        
        // starting dam
        test.print("test dam starting values, should include 5 derived data accessors:");
        blank();
        pause();
        
        // call the added 5 derived data accessors directly,
        // if relying only on print() it's possible they are named differently      
        System.out.println("getAge() alone gives:         " + test.getAge());
        System.out.println("getPercentFull() alone gives: " + test.getPercentFull());
        System.out.println("getStatus() alone gives:      " + test.getStatus());
        System.out.println("getEventDays() alone gives:   " + test.getEventDays());
        System.out.println("getEventDate() alone gives:   " + test.getEventDate());
        pause();
        
    }
    
    //---------------------------------------------------------------------------     
           
    // dam numeric tests [N]
    private static void runDamNumericTests() {
        DamBH1 folsom, oroville, shasta, nimbus;
        
        header("Dam Numeric Tests",
               "checks numerics for all 4 dams",
               "numeric values should match *exactly* versus published sample outputs",
               "full constructor, the 5 derived data accessor methods");
        
        // TODO: update this data each semester with latest actuals
        folsom   = new DamBH1("Folsom",   1956,  365501,  977000,  646, 2383, MEAS_DATE);
        oroville = new DamBH1("Oroville", 1968, 1107709, 3537577,  713, 5118, MEAS_DATE);
        shasta   = new DamBH1("Shasta",   1945, 2153850, 4552000, 3490, 3722, MEAS_DATE);
        nimbus   = new DamBH1("Nimbus",   1955,    8101,    9000, 2135, 1868, MEAS_DATE);
        
        // Folsom
        System.out.println(folsom);
        folsom.print("Folsom: check numeric data vs published");
        pause();
        
        // Oroville
        System.out.println(oroville);
        oroville.print("Oroville: check numeric data vs published");
        pause();
        
        // Shasta
        System.out.println(shasta);
        shasta.print("Shasta: check numeric data vs published");
        pause();
        
        // Nimbus
        System.out.println(nimbus);
        nimbus.print("Nimbus: check numeric data vs published");
        pause();
    }

    //---------------------------------------------------------------------------
    
    // dam holding test [H]
    private static void runDamHoldingTest() {
        
        // updated: change measurement date to 1st day of current year,
        // so that a correct +100 yrs will be more recognizable
        CS12Date date = new CS12Date(1, 1);
        
        DamBH1 test = new DamBH1("holding dam", TEST_YEAR, 
                               TEST_STORAGE, TEST_CAPACITY,
                               2000.0, 2000.0, date);
                               
        header("Dam Holding Test",
               "checks specific case of a holding dam",
               "holding status, 50.0% full, -1 days till event, +100 yrs FROM MEASUREMENTS till event",
               "getPercentFull(), getEventDays(), getEventDate(), print() formats");
               
        test.print("should indicate HOLDING status as noted above");
        pause();
    }
    
    //---------------------------------------------------------------------------
    
    // dam update test [U]
    private static void runDamUpdateTest() {
    
        // updated: start with a true default data as starting point
        /*
        DamBH1 test = new DamBH1("starting dam", TEST_YEAR,
                               TEST_STORAGE, TEST_CAPACITY,
                               TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        */
        DamBH1 test = new DamBH1();
                               
        header("Dam Update Test",
               "show default dam, update() it, show new prompted values",
               "all prompted values are reflected in updated dam",
               "update(), regular and prompting mutators");
        blank();
        
        // starting dam
        test.print("default starting values:");
        test.update(false);
        blank();
        
        // updated dam
        test.print("updated values, make sure all match your inputs");
        pause();
               
    }
    
    //---------------------------------------------------------------------------
    
    // water utils nominal data test [W]
    private static void runDamWaterUtilsNominalTests() {
        
        DamBH1 test = new DamBH1();
        
        header("Dam Water Utilities Tests",
               "test water utilities with non-error data",
               "before and after display of dam shows correct storage/outflow values, other changes as noted",
               "importWater()/releaseWater()/increaseOutflow()/decreaseOutflow(), derived data accessors");
               
        // starting dam state
        test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        test.print("Starting state of test dam, nice round numbers:");
        // import water
        test.importWater(100000);
        test.print("import 100K acre-ft, expect storage up, pct up, days more, date farther");
        pause();
      
        // reset dam state
        test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        test.print("dam is reset...");
        // release water
        test.releaseWater(100000);
        test.print("export 100K acre-ft, expect storage down, pct down, days less, date closer");
        pause();
      
        // reset dam state
        test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        test.print("dam is reset...");       
        // increase outflow
        test.increaseOutflow(500);
        test.print("increase outflow 500 cfs, expect storage/pct constant, outflow up, days down, date closer");
        pause();
      
        // reset dam state
        test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        test.print("dam is reset...");      
        // decrease outflow
        test.decreaseOutflow(500);
        test.print("decrease outflow 500 cfs, expect storage/pct constant, outflow down, days up, date farther");
        pause();   
                        
    }
    
    //---------------------------------------------------------------------------

    // mutator data checking tests [M]
    private static void runDamMutatorDataCheckingTests() {
    
        DamBH1 test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        
        header("Dam Mutator Data Checking Tests",
               "test each of the the checking mutators individually",
               "each proposed change should be rejected with an error msg, final dam state unchanged",
               "checks in setYear(), setStorage(), setCapacity(), setInflow(), setOutflow()");
               
        // starting dam state
        test.print("Starting state of test dam");  
        pause();
      
        // bad year
        message("Try to set year to 1899, should generate error", false);
        test.setYear(1899);
        pause();
      
        // bad storage
        message("Try to set storage < 0, should generate error msg", false);
        test.setStorage(-100);
        pause();
      
        // bad capacity
        message("Try to set capacity < 0, should generate error msg", false);
        test.setCapacity(-100);
        pause();
      
        // storage > capacity
        message("Try to set storage > capacity, should generate error msg", false);
        test.setStorage(test.getCapacity() + 1);
        pause();
      
        // capacity < storage
        message("Try to set capacity < storage, should generate error msg", false);
        test.setCapacity(test.getStorage() - 1);
        pause();
      
        // inflow < 0
        message("Try to set inflow < 0, should generate error msg", false);
        test.setInflow(-500);
        pause();
      
        // outflow < 0
        message("Try to set outflow < 0, should generate error msg", false);
        test.setOutflow(-500);
        pause();
      
        // dam should be unchanged
        test.print("After all tests, dam should still have SAME unchanged round numbers:");
        pause();
        
    }
    
    //---------------------------------------------------------------------------
    
    // data safety checking for date [S]
    private static void runDamDateDataSafeTests() {
    
        DamBH1 test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        CS12Date tempDate;
        int numDays = 3;
        
        header("Dam Date Date Safe Tests",
               "show that measurement date is properly isolated from external changes, as noted",
               "instance variable measurement date should NOT be changing via external date used to set/get it",
               "setDate() and getDate() are using true date copies, setDate() used in full constructor");
        
        test.print("Starting state of test dam, note the date");  
        pause();

        // extract measurements date
        message("getDate() should return us a copy of the measurement date: ", false);
        tempDate = test.getDate();
        System.out.println(tempDate);
        pause();
      
        // advanced extracted date
        message("advance that external date copy by " + numDays + " days: ", false);
        tempDate.laterDate(numDays);
        System.out.println(tempDate);
        pause();
      
        // should not affect date internal to object
        test.print("but the Dam object measurement date should be unchanged:");
        pause();
      
        // advance extracted data again
        message("Update the external date copy by " + numDays + " more days to: ", false);
        tempDate.laterDate(numDays);
        System.out.println(tempDate);
        pause();
      
        // update object with the external date
        test.setDate(tempDate);
        test.print("Update the Dam object using that measurement date and setDate():");
        pause();
      
        // advance external date some more
        message("Now update the external date copy to: ", false);
        tempDate.laterDate(numDays);
        System.out.println(tempDate);
        pause();
      
        // should not affect date internal to object
        test.print("But the Dam object measurement date should not be changed:");
        pause();

        // test data safety on date, when using constructor
        message("Test data safe transfer on date, using full constructor...", true);
        blank();
        tempDate.setYear(MEAS_DATE.getYear());
        tempDate.setMonth(MEAS_DATE.getMonth());
        tempDate.setDay(MEAS_DATE.getDay());
        message("Create a new Dam using this external date: " + tempDate, false);
        test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        test.print("Starting state of test dam, note the measurement date");  
        pause();
      
        // update external date, but Dam date should be unchanged
        tempDate.laterDate(numDays);
        message("Update the external date copy by " + numDays + " more days to: " + tempDate, false);
        test.print("But the Dam object date should be unchanged:");
        pause();
        
    }
    
    //---------------------------------------------------------------------------

    // check mutators for bad data [C]
    private static void runDamConstructorsBadDataTests() {
    
        DamBH1 test;
                
        header("Dam Constructors Bad Data Tests",
               "check that constructors will not allow bad data to be set",
               "full and overloaded constructors reject all bad data with error messages",
               "use of checking mutators inside full and 2 overloaded constructors");
                 
        // full constructor, try all bad data
        message("Full constructor with all bad data: should see 5 error messages", false);
        blank();
        test = new DamBH1("Bad Dam", 1899, -100000, -200000, -1000, -2000, new CS12Date());
        test.print(test.getName() + " should show all default values, input numeric data NOT updated");
        pause();
      
        // constructor #3, use bad year
        message("Overloaded name/year constructor with bad year: should see 1 error message", false);
        test = new DamBH1("Bad Dam", 1885);
        test.print(test.getName() + " should show default year and 5 other default values");
        pause();
      
        // constructor #4, use bad capacity
        message("Overloaded name/capacity constructor with bad capacity: should see 1 error message", false);
        test = new DamBH1("Bad Dam", -500000.0);
        test.print(test.getName() + " should show default capacity and 5 other default values; year should NOT be affected either!");
        pause();
        
    }

    //---------------------------------------------------------------------------

    // check water utilities for bad data [B]
    private static void runDamWaterUtilsBadDataTests() {
        
        double temp;  // for various test purposes
        DamBH1 test = new DamBH1("test dam", TEST_YEAR, TEST_STORAGE, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        
        header("Dam Water Utils Bad Data Tests",
               "check that water utils does not allow bad parameters",
               "all proposed changes should be rejected, dam will be unchanged at end",
               "logic checks in importWater(), releaseWater(), increaseOutflow(), decreaseOutflow()");

        test.print("Starting state of test dam");  
        pause();
      
        message("Each of the following should generate some one-line error message, and leave dam unchanged...", false);
        blank();
      
        // negative import
        temp = -100000;
        message("Can't import a negative amount of " + temp, false);
        test.importWater(temp);
        pause();
      
        // import cannot overfill
        temp = test.getCapacity() - test.getStorage() + 1;
        message("Can't overfill dam by importing " + temp, false);
        test.importWater(temp);
        pause();
      
        // negative release
        temp = -100000;
        message("Can't release a negative amount of " + temp, false);
        test.releaseWater(temp);
        pause();
     
        // release cannot drain
        temp = test.getStorage() + 1;
        message("Can't empty dam by releasing " + temp, false);
        test.releaseWater(temp);
        pause();
      
        // negative outflow increase
        temp = -500;
        message("Can't increase outflow by a negative amount of " + temp, false);
        test.increaseOutflow(temp);
        pause();
      
        // negative outflow increase
        temp = -500;
        message("Can't decrease outflow by a negative amount of " + temp, false);
        test.decreaseOutflow(temp);
        pause();
      
        // cannot reduce outflow past 0
        temp = test.getOutflow() + 500;
        message("Can't decrease outflow below 0 by amount of " + temp, false);
        test.decreaseOutflow(temp);
        pause();
      
        // confirm dam is unaltered after all the previous
        test.print("Dam's final state after all operations should be unaltered");
        pause();
        blank();
      
        message("Now test the special cases of changing the outflow when storage is already 0", false);
      
        // reset up new starting point with storage=0
        test = test = new DamBH1("test dam", TEST_YEAR, 0.0, TEST_CAPACITY, TEST_INFLOW, TEST_OUTFLOW, MEAS_DATE);
        test.print("New starting state of test dam, with storage=0");  
        pause();
      
        // can't increase outflow if storage=0
        temp = 456;
        message("Can't increase outflow by valid amount " + temp + " if storage is already 0", false);
        test.increaseOutflow(temp);
        pause();
      
        // can't decrease outflow if storage=0
        temp = 345;
        message("Can't decrease outflow by valid amount " + temp + " if storage is already 0", false);
        test.decreaseOutflow(temp);

        // confirm dam is unaltered after all the previous
        test.print("Dam's final state after all operations should be unaltered");
        pause();
    
    }
    
    //-------------------------------------------------------------------------------------------------------------
    // Feel free to add these following methods, or ones similar to these, to your own Utils
    // (just make yours public not private)
    //-------------------------------------------------------------------------------------------------------------
   
    // display related methods -------------------------------------------------
    
    // utility method which prints a specified spacer N times
    private static void spacer(char ch, int n) {
        for (int i=0; i < n; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }
   
    // just a shortcut to printing a bounded message
    private static void message(String msg) {
        message(msg, true);
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
    
    // display a standard formatted title and purpose of a test, and what to check if it doesn't pass
    private static void header(String title, String purpose, String expected, String check) {
        blank();
        message(title, true);
        message("Test purpose:        " + purpose, false);
        message("Expected result:     " + expected, false);
        message("If it fails, check:  " + check, false);
        blank();
        pause();
    }
   
    // print a simple blank line
    private static void blank() {
        message("", false);
    }

    // execution related methods ------------------------------------------------
    
    // pauses execution until any key is pressed, specific prompt
    private static void pause(String message) {
        // ignores any returned value
        readString(message);    // update with own Utils version if desired, but add boolean input
        blank();                // add a blank line
    }
    
    // pauses execution until any key is pressed, generic prompt
    private static void pause() {
        pause("Press <Enter> to continue... ");
    }
    
    // get a String value (standalone, cmd-line only version)
    // update with own Utils version if desired, but add boolean input
    private static String readString(String prompt) {
    
        // set up data and objects
        String data;
        Scanner input = new Scanner(System.in);

        System.out.print(prompt);
        data = input.nextLine();
      
        return data;
    }

} // end class