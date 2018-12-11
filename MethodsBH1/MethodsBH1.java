/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       09/25/18
 *
 * Filename:   MethodsBH1.java
 *
 * Purpose:    Using external input to modify data using methods.
 */

// imports for using Java class methods
import java.util.Scanner;

public class MethodsBH1 {

    // main method of the class
    public static void main(String [] args) {
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
         
        // Declaring variables
        double numParseFa;
        double numParseCel;
        double numParseDollar;
        double numParseEuro;
        String inputAnsCel;
        String inputAnsEuro;
        
        //(A) Conversion of Fahrenheit to Celsius
        // would have to make new func for prints, tried implement to doingNumDouble
        System.out.print("Enter temperature in deg F >");
        numParseFa = doingNumDouble();
        numParseCel = doingFarToCel(numParseFa);
        inputAnsCel = numParseFa + " deg F is equal to " + numParseCel + " deg C\n";
        doingOutput(inputAnsCel);
        
        //(B) Currency conversion of Dollars to Euros
        System.out.print("Enter number of USD to convert >");
        numParseDollar = doingNumDouble();
        numParseEuro = doingUsdToEuro(numParseDollar);
        inputAnsEuro = "$" + numParseDollar + " is equal to " + numParseEuro + " Euros\n";
        doingOutput(inputAnsEuro);
        
    } // end main
    
    //(1) method for obtaining a generic double value
    public static double doingNumDouble() {
        double numIn;
        
        Scanner input = new Scanner(System.in);
        numIn = input.nextDouble();
        return(numIn);
    }
    
    //(2) method for displaying generic output in a box
    public static void doingOutput(String inputAns) {
        
        System.out.println("========================================\n" + inputAns +
                           "========================================\n");
    
    }
    
    //(3) method for actual converting Fahrenheit to Celsius
    public static double doingFarToCel (double numFar) {
        
        double numCel;
        numCel = ((numFar - 32)*5)/9;
        return (numCel);
    
    }
    
    //(4) method for actual converting Dollars to Euros
    public static double doingUsdToEuro (double numDollar) {
        final double CONV_RATE;
        double numEuro;
        
        CONV_RATE = .860336;
        numEuro = CONV_RATE * numDollar;
        return (numEuro);
    
    }
      
}
