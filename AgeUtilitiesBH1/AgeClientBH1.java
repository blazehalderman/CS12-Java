/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       10/27/18
 *
 * Filename:   AgeClientBH1.java
 *
 * Purpose:    Class used to test UtilsBH1 class for Age checking
 */

public class AgeClientBH1     {

    public static void main(String [] args)     {
    
        // declaring variables
        int bdMonth;
        int bdDay;
        int bdYear;
        CS12Date newBirthDate;
        CS12Date refCurrentDate = new CS12Date();
        CS12Date hardCurrentDate1 = new CS12Date(5, 23, 1999);
        CS12Date hardCurrentDate2 = new CS12Date(5, 22, 2099);
        
        // algorithm/logic for program 
        // TEST 1 with flag false
        System.out.println("Test 1: 1-input getAge(), age today, use Scanner mode input (flag=false)");
        bdMonth = UtilsBH1.readInt("Enter birth month: ", false);
        bdDay = UtilsBH1.readInt("Enter birth day: ", false);
        bdYear = UtilsBH1.readInt("Enter birth year: ", false);
        newBirthDate = new CS12Date(bdMonth, bdDay, bdYear);
        System.out.println("birthday: " + newBirthDate + " age = " + UtilsBH1.getAge(newBirthDate, refCurrentDate) + "\n");
        bdMonth = 0;
        bdDay = 0;
        bdYear = 0;

        // TEST 2 with flag true
        System.out.println("TEST 2: 1-input get Age(), age today, use JOptionPane mode input (flag=true)\n(from GUI inputs)");
        bdMonth = UtilsBH1.readInt("Enter birth month: ", true);
        bdDay = UtilsBH1.readInt("Enter birth day: ", true);
        bdYear = UtilsBH1.readInt("Enter birth year: ", true);
        newBirthDate = new CS12Date(bdMonth, bdDay, bdYear);
        System.out.println("birthday: " + newBirthDate + " age = " + UtilsBH1.getAge(newBirthDate, refCurrentDate) + "\n");
        
        // TEST 3 hardwired dates with age at 1 day before 100
        System.out.println("TEST 3: 2-input getAge(), age as of a milestone date for YOU, hardwire input dates");
        System.out.println("birthday: " + hardCurrentDate1 + " age = " + UtilsBH1.getAge(hardCurrentDate1, hardCurrentDate2) + "\t\tas of: " + hardCurrentDate2);
    }
      
}
