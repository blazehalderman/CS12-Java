/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       10/21/18
 *
 * Filename:   ConditionsBH1.java
 *
 * Purpose:    compare values using conditional expressions
 */

import java.util.Scanner;

public class ConditionsBH1     {

    public static void main(String [] args)     {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
         
        Scanner input = new Scanner(System.in);
        final int NUM_DAY_WEEK;
        boolean boolTime;
        final int NUM_AGE_VAL;
        final String PAGE_HEAD;
        final int numToddler;
        final int numChild;
        final int numAdult;
        final int numSenior;
        final int numThurs;
        final int numTues;
        final int numWeekend;
        final boolean BOOL_NO_RATE;
        final boolean BOOL_KIDS_RATE;
        final boolean BOOL_SENIOR_RATE;
        final boolean BOOL_DISC_RATE;
        final boolean BOOL_FULL_RATE;
        
        numToddler = 4;
        numChild = 12;
        numAdult = 59;
        numSenior = 60;
        numThurs = 4;
        numTues = 2;
        numWeekend = 6;
        PAGE_HEAD = "==============================================\n" + 
        "\t\t\t\t\tMOVIE RATES\n==============================================\n";

        // Computations: computations, algorithms
        
        // Asking for user input for the three values specified, formatting
        
        System.out.print(String.format("%-30s%-30s", PAGE_HEAD, "Enter day of week (1=Mon ... 7=Sun) > "));
        NUM_DAY_WEEK = input.nextInt();
        
        System.out.print(String.format("%38s", "Evening show? > "));
        boolTime = input.nextBoolean();
        
        System.out.print(String.format("%38s", "Enter patron age > "));
        NUM_AGE_VAL = input.nextInt();
        System.out.print(String.format("%30s", "==============================================\n"));
        
        // if the age is lower then 4 years old and its not Tuesday evening or Thursday afternoon
        BOOL_NO_RATE = ((NUM_AGE_VAL <= numToddler) && ((NUM_DAY_WEEK < numWeekend) && 
                       (!(numTues == NUM_DAY_WEEK && boolTime == true) && 
                       (!(numThurs == NUM_DAY_WEEK && boolTime == false)))));
        
        /* if the age is between 5 and 12 or the age is 0 and 4 on a weekend
        and its not Tuesday eveing or Thursday afternoon */
        BOOL_KIDS_RATE = (((NUM_AGE_VAL <= numChild && NUM_AGE_VAL > numToddler) || 
                         ((NUM_AGE_VAL <= numToddler) && (NUM_DAY_WEEK >= numWeekend))) && 
                         (!(numTues == NUM_DAY_WEEK && boolTime == true) && 
                         (!(numThurs == NUM_DAY_WEEK && boolTime == false))));
        
        // if the age is between 13 and 59 and its not Tuesday evening or Thursday afternoon               
        BOOL_FULL_RATE = (((NUM_AGE_VAL > numChild) && (NUM_AGE_VAL <= numAdult)) &&
                         (!(numTues == NUM_DAY_WEEK && boolTime == true) && 
                         (!(numThurs == NUM_DAY_WEEK && boolTime == false))));
        
        // if the age is over 60 and its not Tuesday evening or Thursday afternoon
        BOOL_SENIOR_RATE = ((NUM_AGE_VAL >= numSenior) && 
                           (!(numTues == NUM_DAY_WEEK && boolTime == true) && 
                           (!(numThurs == NUM_DAY_WEEK && boolTime == false))));
        
        // if its Tuesday evening or Thursday afternoon
        BOOL_DISC_RATE = ((numTues == NUM_DAY_WEEK && boolTime == true) || 
                         (numThurs == NUM_DAY_WEEK && boolTime == false));
        
        // outputs for rates               
        System.out.print(String.format("Rate 0 (no charge):\t\t\t%b\n", BOOL_NO_RATE));
        System.out.print(String.format("Rate 1 (kids rate):\t\t\t%b\n", BOOL_KIDS_RATE));
        System.out.print(String.format("Rate 2 (senior rate):\t\t%b\n", BOOL_SENIOR_RATE));
        System.out.print(String.format("Rate 3 (discount shows):\t%b\n", BOOL_DISC_RATE));
        System.out.print(String.format("Rate 4 (fulll price):\t\t%b\n", BOOL_FULL_RATE));
     }
      
}
