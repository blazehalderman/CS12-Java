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
        // TODO: 1) add a second boolean *input argument* (in the above method interface) for a 2nd "guiMode" input
        //       2) wrap an if-else around the *existing* Scanner mode input code (lines 45-47)
        //       3) use the added boolean input in the if(....) logic, to determine which path to take
        //       4) provide the equivalent JOptionMode code as the *other* branch
        //
        //       if F, get input as shown from Scanner (command line)
        //       if T, get input from JOptionPane (popup GUI) - YOU PROVIDE THIS CODE
    
        // set up data and objects
        Scanner input;
        int data;
        
        // TODO: wrap an if-else around THIS following code, as noted above
        if (flagGUI == false) {
        //--------------------------
        // prompt for an input int value using Scanner mode, for "false" case
        input = new Scanner(System.in);
        System.out.print(prompt);
        data = input.nextInt();
        }
        // TODO: create the equivalent "else" steps using JOptionPane mode, for "true" case
        //--------------------------
        else {
            data = Integer.parseInt(JOptionPane.showInputDialog(prompt));
        }
        return data; // regardless of whether obtained by Scanner or JOptionPane
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
        
        // TODO: calculate the age correctly, given birthdate AND a reference date
        //   1) take apart both input dates using accessors:  2 CS12Date objects --> 6 individual M,D,Y ints
        bdMonth = dateBd.getMonth();
        bdDay = dateBd.getDay();
        bdYear = dateBd.getYear();
        refMonth = dateRef.getMonth();
        refDay = dateRef.getDay();
        refYear = dateRef.getYear();
        //   2) devise needed logic to calculate age for dateBd "as of" dateRef (see program spec and diagrams)
        //   3) do NOT print age from here, just return its value (only print message in error case, age=-1)
        //   4) for the future BD case (age = -1) ONLY, print an error message as shown in sample outputs,
        //        incorporating birthdate, reference date, and age = -1
        
        // TODO: create age logic here (multiple correct ways, here is ONE simple possibility)
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