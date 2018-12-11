/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       09/15/18
 *
 * Filename:   VariablesBH1.java
 *
 * Purpose:    Setup and manage variable flow in a java program
 */

public class VariablesBH1   {

    public static void main(String[] args)  {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
         
        // Defining variables
        
        final int       SINGLE_DOZEN;
        boolean         boolAC;
        int             numZip;
        float           priceTarget;
        int             numStock;
        float           numDJIA;
        final double    NUM_PLACER_TAX;
        char            gradeLetter;
        String          fullNameEmily;
        long            numISBN;
        float           areaShape;
            
        //initializing a variable
            
        SINGLE_DOZEN =      12;
        boolAC =            true;
        numZip =            96161;
        priceTarget =       49.99F;
        numStock =          42;
        numDJIA =           26154.67F;
        NUM_PLACER_TAX =    0.0725;
        gradeLetter =       'A';
        fullNameEmily =     "Emily Constance Lockhart";
        numISBN =           9780375842207L;
        areaShape =         452.54F;
            
        // Computations: computations, algorithms
         
        // Outputs: outputs, formatting, display
        
        System.out.println("The value for a dozen is:       " + SINGLE_DOZEN + "\n");
        System.out.println("Is the AC on?                   " + boolAC + "\n");
        System.out.println("Delivery zip code is:           " + numZip + "\n");
        System.out.println("Target headphones costs:        " + priceTarget + "\n");
        System.out.println("packages in stock:              " + numStock + "\n");
        System.out.println("Recent Dow Jones close:         " + numDJIA + "\n");
        System.out.println("Placer County Tax Rate:         " + NUM_PLACER_TAX + "\n");
        System.out.println("Andrew's math grade:            " + gradeLetter + "\n");
        System.out.println("Emily's full name:              " + fullNameEmily + "\n");
        System.out.println("Amazon book ISBN-13:            " + numISBN + "\n");
        System.out.println("Geometric shape area:           " + areaShape + "\n");
    
    }
      
}
