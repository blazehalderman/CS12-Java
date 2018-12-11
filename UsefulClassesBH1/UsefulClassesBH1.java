/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       10/09/18
 *
 * Filename:   UsefulClassesBH1.java
 *
 * Purpose:    A general template for all future java programs
 */

// only importing for practice purposes, in future not necessary
import java.util.Scanner;
import java.util.Random;

public class UsefulClassesBH1     {

    public static void main(String [] args)     {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int minInt;
        int maxInt;
        int ranNum1;
        int ranNum2;
        int ranNum3;
        int ranNum4;
        float aSide;
        float bSide;
        float sRadius;
         
        // Computations: computations, algorithms
         
        // Prompt for maximum and minimum integers, generate random nums 
        System.out.print("Enter minimum random number bound: ");
        minInt = input.nextInt();
        System.out.print("Enter maximum random number bound: ");
        maxInt = input.nextInt();
         
        // assigning a random integer between a ranget
        ranNum1 = rand.nextInt(maxInt-minInt+1)+minInt;
        ranNum2 = rand.nextInt(maxInt-minInt+1)+minInt;
        ranNum3 = rand.nextInt(maxInt-minInt+1)+minInt;
        ranNum4 = rand.nextInt(maxInt-minInt+1)+minInt;
        System.out.println("\n1) range: " + minInt + "-" + maxInt + " random #s: " +
                        ranNum1 + " " + ranNum2 + " " + ranNum3 + " " + ranNum4);
        
        // find maximum and minimum amounts of the random numbers
        System.out.println("\n2a) smallest random number: " + 
                           Math.min(Math.min(Math.min(ranNum1, ranNum2), ranNum3), ranNum4));
        System.out.println("2b) largest random number: " + 
                           Math.max(Math.max(Math.max(ranNum1, ranNum2), ranNum3), ranNum4));   
        
        // find the hypotenuse of a right triangle given two floats
        System.out.print("\nEnter side a: ");
        aSide = input.nextFloat();
        System.out.print("Enter side b: ");
        bSide = input.nextFloat();
        System.out.println("\n3) sides: a = " + aSide + " b = " + 
                            bSide + "\n   hyp:   h = " + 
                            Math.sqrt(Math.pow(aSide, 2) + Math.pow(bSide, 2)) +
                            " (exact)\n\t\t  h = " + 
                            Math.round(Math.sqrt(Math.pow(aSide, 2) + Math.pow(bSide, 2))) + 
                            " (rounded)");
        
        // find a spheres radius given a radius
        System.out.print("\nEnter sphere radius: ");
        sRadius = input.nextFloat();
        System.out.println("\n4) sphere r = " + sRadius + "\tsphere V = " +
        (4*Math.PI/3)*(Math.pow(sRadius, 3)));
        
    }
      
}
