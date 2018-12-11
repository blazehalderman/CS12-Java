/*
 * Name:       Rob Lapkass
 *
 * Course:     CS-12, Fall 2018
 *
 * Date:       10/12/18
 *
 * Filename:   UtilsTest1RL.java
 *
 * Purpose:    Test program for age algorithm correctness of PRGM10
 *             (instructor-provided).
 *             A series of test birthdates are provided, along with
 *             the expected age, and age results compared against expected.
 *
 *             This program has been generalized, so that it should work for either
 *             spring or fall semesters, just by toggling one flag.
 *
 *             =====================================================================
 *             INSTRUCTIONS: Do global replace of utility class name:
 *                in jGRASP use: Edit: Find/Replace
 *                or: Ctrl-F
 *                change UtilsRL ==> your Utils class name
 *             Then run this program and inspect pass/fail results.
 *             =====================================================================
 *             Do not make any other changes to this file - it must run as-provided!
 *             =====================================================================
 */

import java.util.Random;

public class UtilsTest1RL {
    public static void main(String [] args) {
    
        // declarations
        CS12Date bd, ref, now;
        int month, day, year;
        int age;
        
        // semester flag, T = spring, F = fall
        boolean semFlag = false;
        
        // test program control settings
        boolean doAgeTests = true;
        
        // date initializations
        bd = new CS12Date();
        ref = new CS12Date();
        final int CURR_YEAR = bd.getYear();
        final int CURR_MONTH = bd.getMonth();
    
        // perform age tests
        if (doAgeTests) {
        
            // program output header
            System.out.println("=============================");
            System.out.println("       Age test results      ");
            System.out.println("(test driver client provided)");
            System.out.println("=============================");
        
            //----------------------------------------------------------

            // test for birthdays BEFORE current date
            System.out.println("Birthdays BEFORE current date:");
            
            // B1: BD a day before current date
            bd = UtilsBH1.today();
            bd.priorDate(1);
            bd.setYear(CURR_YEAR - 46);
            runTest1("B1", bd, 46);
                
            // B2: BD a day before current date
            bd = UtilsBH1.today();
            bd.priorDate(1);
            runTest1("B2", bd, 0);
        
            // B3: prior month, early day in month
            bd.setDate(getPriorMonth(semFlag), 1, CURR_YEAR - 35);
            runTest1("B3", bd, 35);
                
            // B4: prior month, early day in month, THIS year
            bd.setDate(getPriorMonth(semFlag), 9, CURR_YEAR);
            runTest1("B4", bd, 0);            
            
            // B5: prior month, late day in month
            bd.setDate(getPriorMonth(semFlag), 28, CURR_YEAR - 18);
            runTest1("B5", bd, 18);
                
            // B6: prior month, late day in month, THIS year
            bd.setDate(getPriorMonth(semFlag), 27, CURR_YEAR);
            runTest1("B6", bd, 0);
            
            // B7: this month, earlier day in month
            bd.setDate(CURR_MONTH, 1, CURR_YEAR - 82);
            runTest1("B7", bd, 82);
                
            // B8: this month, earlier day in month, THIS year
            bd.setDate(CURR_MONTH, 1, CURR_YEAR);
            runTest1("B8", bd, 0);
            
            //----------------------------------------------------------
            
            // test for birthdays AFTER current date
            System.out.println("\nBirthdays AFTER current date:");
            
            // A1: tomorrow is BD
            bd = UtilsBH1.today();
            bd.laterDate(1);
            bd.setYear(CURR_YEAR - 47);
            runTest1("A1", bd, 47 - 1);
            
            // A2: future month, early day in month
            bd.setDate(getFutureMonth(semFlag), 9, CURR_YEAR - 16);
            runTest1("A2", bd, 16 - 1);
                
            // A3: future month, early day in month
            bd.setDate(getFutureMonth(semFlag), 4, CURR_YEAR - 32);
            runTest1("A3", bd, 32 - 1);
            
            // A4: future month, late day in month
            bd.setDate(getFutureMonth(semFlag), 30, CURR_YEAR - 21);
            runTest1("A4", bd, 21 - 1);
                
            // A5: future month, late day in month
            bd.setDate(getFutureMonth(semFlag), 29, CURR_YEAR - 3);
            runTest1("A5", bd, 3 - 1);
        
            //----------------------------------------------------------

            // test for birthdays ON today's date
            System.out.println("\nBirthdays ON today's date:");
        
            // T1: today, born today
            bd = UtilsBH1.today();
            runTest1("T1", bd, 0);
                
            // T2: today, kids or teens
            bd = UtilsBH1.today();
            bd.setYear(CURR_YEAR - 8);
            runTest1("T2", bd, 8);
            
            // T3: today, millenials
            bd = UtilsBH1.today();
            bd.setYear(CURR_YEAR - 22);
            runTest1("T3", bd, 22);
            
            // T4: today, baby boomers
            bd = UtilsBH1.today();
            bd.setYear(CURR_YEAR - 52);
            runTest1("T4", bd, 52);
                
            // T5: today, seniors
            bd = UtilsBH1.today();
            bd.setYear(CURR_YEAR - 72);
            runTest1("T5", bd, 72);
        
            //----------------------------------------------------------

            // test for future dates
            System.out.println("\nBirthdays in FUTURE:");
            System.out.println("==> error message to user **generated by getAge()** must display for EACH future date\n");
        
            // F1: tomorrow
            bd = UtilsBH1.today();
            bd.nextDay();
            runTest1("F1", bd, -1);
            
            // F2: future date in a week or so
            bd = UtilsBH1.today();
            bd.laterDate(10);
            runTest1("F2", bd, -1);
            
            // F3: future month this year, early date
            bd = UtilsBH1.today();
            bd.setDate(getFutureMonth(semFlag), 1, CURR_YEAR);
            runTest1("F3", bd, -1);
            
            // F4: future month this year, late date
            bd = UtilsBH1.today();
            bd.setDate(getFutureMonth(semFlag), 28, CURR_YEAR);
            runTest1("F4", bd, -1);
            
            // F5: future year, early month
            bd = UtilsBH1.today();
            bd.setDate(2, 15, CURR_YEAR + 4);
            runTest1("F5", bd, -1);
            
            // F6: future year, late month
            bd.setDate(11, 9, CURR_YEAR + 3);
            runTest1("F6", bd, -1);
            
            //----------------------------------------------------------

            // test age on milestone dates
            System.out.println("\nPrior birthdays (dead or alive) on future milestone dates:");
        
            // M1: George Washington 300th
            bd.setDate(2, 22, 1732);
            ref.setDate(2, 22, 2032);
            runTest2("M1", bd, ref, 300, "George Washington 300th");
            ref.setDate(2, 21, 2032);
            runTest2("M1", bd, ref, 299, "George Washington 300th, day before");            
        
            // M2: instructor 65th
            bd.setDate(7, 18, 1963);
            ref.setDate(7, 18, 2028);
            runTest2("M2", bd, ref, 65, "instructor 65th");
            ref.setDate(7, 17, 2028);
            runTest2("M2", bd, ref, 64, "instructor 65th, day before");    
            
        } // end age tests
        
    } // end main
    
    //-----------------------------------------------------------------------------
    
    // generate a future month, depending upon whether spring or fall semester
    private static int getFutureMonth(boolean isSpring) {
    
        Random rand = new Random();
        int month;
        
        // spring or fall semester?
        if (isSpring) {
            month = rand.nextInt(7) + 6;   // June-Dec
        }
        else {
            month = 12;  // Dec only
        }
        
        return month;
    }
    
    // generate a prior month, depending upon whether spring or fall semester
    private static int getPriorMonth(boolean isSpring) {
    
        Random rand = new Random();
        int month;
        
        // spring or fall semester?
        if (isSpring) {
            month = rand.nextInt(2) + 1;   // Jan-Feb
        }
        else {
            month = rand.nextInt(9) + 1;   // Jan-Sept
        }
        
        return month;
    }
    
    // generate a random age within a certain range, to be used with an age test case
    private static int getRandomAge(int minAge, int maxAge) {
        
        Random rand = new Random();
        int age;
        
        // random age over specified range
        age = rand.nextInt(maxAge - minAge + 1) + minAge;
        
        return age;
    }

    //-----------------------------------------------------------------------------
    
    // test the single-input age form with a BD and an expected age
    private static void runTest1(String test, CS12Date bd, int expectedAge) {
    
        // test the 1-input form (age as of TODAY)
        int age = UtilsBH1.getAge(bd);
        
        // display test results
        //System.out.println("bd: " + bd + 
        //                   "\tas of: " + UtilsRL.today() +
        //                   "\tage: " + age +
        //                   "\texpected: " + expectedAge +
        //                   "\tpass: " + (age==expectedAge ? true : false));
                     
        // rewritten using format specifiers to avoid tabbing      
        System.out.printf("%-5s%3s%11s%9s%11s%8s%4d%11s%4d%8s%-5b\n",
                          test + ')',
                          "bd: ", bd,
                          "as of:", UtilsBH1.today(),
                          "age:", age,
                          "expected:", expectedAge,
                          "pass: ", (age==expectedAge ? true : false));
        
    } // end runTest1

    //-----------------------------------------------------------------------------
    
    // test the two-input age form with a BD, milestone date, and an expected age
    private static void runTest2(String test, CS12Date bd, CS12Date ref, int expectedAge, String text) {
    
        // test the 2-input form (age as of some reference date)
        int age = UtilsBH1.getAge(bd, ref);
        
        // display test results
        //System.out.println("bd: " + bd + 
        //                   "\ton: " + ref +
        //                   "\tage: " + age +
        //                   "\texpected: " + expectedAge +
        //                   "\tpass: " + (age==expectedAge ? true : false) +
        //                   "\t" + text);
        
        // rewritten using format specifiers to avoid tabbing      
        System.out.printf("%-5s%3s%11s%9s%11s%8s%4d%11s%4d%8s%-8b%s\n",
                          test + ')',
                          "bd: ", bd,
                          "on:", ref,
                          "age:", age,
                          "expected:", expectedAge,
                          "pass: ", (age==expectedAge ? true : false),
                          text);
                   
    } // end runTest2
    
} // end class