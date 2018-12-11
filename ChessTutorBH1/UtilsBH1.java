/*
 * Name:        Blaze Halderman      
 *
 * Course:      CS-12 Fall 2018 
 *
 * Date:        10/27/2018      
 *
 * Filename:    UtilsBH1.java   
 *
 * Purpose:    Starter CS-12 utilities file.
 *             This class is a collection of useful utility methods
 *              which are called statically:    UtilsFL.method()
 *
 *             TODO: reword the purpose of this file into your OWN words
 *
 *             THIS FILE RELIES UPON HAVING CS12Date.java IN LOCAL DIRECTORY
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class UtilsBH1 {

    //---------------------------------------------------------------------------
    // user input methods, by datatype
    //---------------------------------------------------------------------------
    
    // get an int value
    public static int readInt(String prompt, boolean flagGUI) {
        // set up data and objects
        Scanner input;
        int data;
        input = new Scanner(System.in);
        
        // initialize variables
        boolean failed = true;
        data = 0;
        
        // if the flag statement is false
        if (flagGUI == false) {
            // prompt for an input int value using Scanner mode, for "false" case
            System.out.print(prompt);
            while (!(input.hasNextInt())) {
                System.out.print("Please enter an integer value: ");
                input.next();
            }
            data = input.nextInt();
        }
        // if the flag statement is true
        else {
            while (failed == true) {
                try {
                    data = Integer.parseInt(JOptionPane.showInputDialog(null, prompt));
                    failed = false;
                }
                catch (NumberFormatException nfe) {
                // intercepts failed attempt to convert an int
                }
            }
        }
        return data; // regardless of whether obtained by Scanner or JOptionPane
    }
    
    // get a char value
    public static char readChar(String prompt, boolean flagGUI)    {
        Scanner input;
        char data;
        
        // if flagGUI equals false, get user input from command line
        if (flagGUI == false) {
            input = new Scanner(System.in);
            System.out.print(prompt);
            data = input.next().charAt(0);
        }
        // else get user input from GUI menu
        else {
            data = JOptionPane.showInputDialog(null, prompt).charAt(0);
        }
        return data;
    }
    
    //---------------------------------------------------------------------------
    // age-related methods
    //---------------------------------------------------------------------------
    
    // returns the age as of some REFERENCE date (2-input overloaded form, MODS NEEDED)
    public static int getAge(CS12Date dateBd, CS12Date dateRef) {
        int age = -2; // starter output
        int bdMonth;
        int bdDay;
        int bdYear;
        int refMonth;
        int refDay;
        int refYear;
        
        //   1) take apart both input dates using accessors:  2 CS12Date objects --> 6 individual M,D,Y ints
        bdMonth = dateBd.getMonth();
        bdDay = dateBd.getDay();
        bdYear = dateBd.getYear();
        refMonth = dateRef.getMonth();
        refDay = dateRef.getDay();
        refYear = dateRef.getYear();
        //   helpful hint: start out by *pseudocoding* what case(s) each logic branch should be checking for
        if ((bdYear > refYear) || (bdMonth > refMonth && bdYear >= refYear) || (bdMonth >= refMonth && bdYear >= refYear && refDay < bdDay)) {
            System.out.println("ERROR: provided birthdate " + dateBd + " is after current date");
            age = -1;
        }
        else if ((bdMonth > refMonth)) {
            age = refYear - bdYear - 1;
        }
        else if ((bdMonth == refMonth && bdDay > refDay)) {
            age = refYear - bdYear - 1;
        }
        else
            age = refYear - bdYear;
        
        return age;
        
    } // end 2-input overloaded version
    
    //---------------------------------------------------------------------------

    // returns the age as of TODAY'S date (1-input overloaded form, NO CHANGES NEEDED)
    public static int getAge(CS12Date dateBd) {
        int age;
        CS12Date dateToday = today();
        
        // calls overloaded version of above method, using TODAY as the reference date
        age = getAge(dateBd, dateToday);  
        return age;
        
    } // end 1-input overloaded version
    
    
    //---------------------------------------------------------------------------
    // date-related methods 
    //---------------------------------------------------------------------------
    
    // returns today's date as a CS12Date (NO CHANGES NEEDED)
    public static CS12Date today() {
    
        return new CS12Date();
        
    }
       
} // end class