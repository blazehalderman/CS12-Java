/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       11/2/18
 *
 * Filename:   ChessTutorBH1.java
 *
 * Purpose:    designing a chess tutor earnings program
 */

public class ChessTutorBH1     {

    public static void main(String [] args)     {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
        char option;
        String menuOptions;
        int validDay;
        double valueEarnings;
        final double DOUBLE_MILLION;
        final double DOUBLE_BILLION;
        boolean millionPass;
        boolean billionPass;
        
        valueEarnings = 0;
        DOUBLE_MILLION = 1000000.00;
        DOUBLE_BILLION = 1000000000.00;
        millionPass = false;
        billionPass = false;
        menuOptions = "\n\n-----------------------------\nChess Tutoring Income Options\n-----------------------------\n" +
        "Daily earnings on Day N\t\t\t[D]\n" + "Total earnings up to day N\t\t[T]\n" + 
        "History of earnings up to Day N\t[H]\n" + "Quit\t\t\t\t\t\t\t[Q]\n" + "Enter option: ";
        
        // Computations: computations, algorithms
        option = UtilsBH1.readChar(menuOptions, false);
        while ((option != 'Q') && (option != 'q'))    {
            switch (option) {
                case 'd':
                case 'D':
                    validDay = getValidDay();
                    System.out.printf("\n==> Daily earnings on Day " + validDay + 
                    " will be: $%,.2f\n", Math.pow(2, validDay - 1)/100);
                    break;
                    
                case 't':
                case 'T':
                    validDay = getValidDay();
                    for (int i = 1; i <= validDay; i++)  {
                        valueEarnings += Math.pow(2, i - 1)/100;
                    }
                    System.out.printf("\n==> Total earnings thru Day " + validDay + 
                    " will be: $%,.2f\n", valueEarnings);
                    valueEarnings = 0;
                    break;
                
                case 'h':  
                case 'H':
                    validDay = getValidDay();
                    System.out.println("Day\t\t\t\tDaily earnings [$]\t\t\t\tTotal earnings [$]");
                    for (int i = 1; i <= validDay; i++)  {
                        valueEarnings += Math.pow(2, i - 1)/100;
                        System.out.printf("\n%3d%,31.2f%,32.2f", i, Math.pow(2, i - 1)/100, valueEarnings);
                        if ((valueEarnings >= DOUBLE_MILLION) && !(millionPass))    {
                            System.out.print(" <== DAY " + i + ": I'M A MILLIONAIRE!!!");
                            millionPass = true;
                        }
                        if ((valueEarnings >= DOUBLE_BILLION) && !(billionPass))   {
                            System.out.print(" <== DAY " + i + ": I'M A BILLIONAIRE!!!");
                            billionPass = true;
                        }
                    }
                    valueEarnings = 0;
                    break;
                default:
                    System.out.println("Unrecognized option " + option + 
                    ": please try again\n");
                    break;
            }
            option = UtilsBH1.readChar(menuOptions, false);
            
        }
        System.out.println("Exit upon user request");      
    
    }
    
    // method for validating a day from 1 to 64
    public static int getValidDay() {
        int validDay;
        final int MAX_VALID_DAY;
        
        MAX_VALID_DAY = 64;
        validDay = UtilsBH1.readInt("Enter chess teaching day [1 - 64] > ", false);
        while((validDay > MAX_VALID_DAY) || (validDay < 1))   {
            validDay = UtilsBH1.readInt("Enter chess teaching day [1 - 64] > ", false);
        }
        return validDay;
    }
      
}
