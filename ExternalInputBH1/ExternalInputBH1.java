/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       09/22/18
 *
 * Filename:   ExternalInputBH1.java
 *
 * Purpose:    Using external input to modify data.
 */
 
// made changes based on previously graded assignment
import java.util.Scanner;
public class ExternalInputBH1     {

    public static void main(String [] args)     {
    
         /* Data: variables setup, constants, user inputs
         (separate lines, if you wish)*/
         
         // Declaring variables
         
         Scanner input = new Scanner(System.in);
         
         // problem 1 variables
         float priceSandwich;
         float priceChips;
         float priceSoda;
         float totalPrice;
         
         // problem 2 and 3 variables
         int totalEggs;
         final int ONE_DOZEN;
         int fullOneDozen;
         int leftOverDozen;
         
         // problem 4 variables
         float itemPrice;
         final float TOTAL_SALES_TAX;
         float itemTotal;
         
         // problem 5 variables
         double totalRadius;
         final double PI;
         double totalArea;
         
         // problem 6 variables
         int totalHits;
         int totalAtBats;
         float totalBatAvg;
         
         // problem 7 variables
         int Widget1;
         
         // problem 8 variables
         int Widget2;
         int addWidget2;
         
         // Initializing variables
         System.out.print("Enter price of Sandwich: ");
         priceSandwich = input.nextFloat();
         System.out.print("Enter price of Chips: ");
         priceChips = input.nextFloat();
         System.out.print("Enter price of Soda: ");
         priceSoda = input.nextFloat();
         System.out.print("Enter number of total eggs: ");
         totalEggs = input.nextInt();
         ONE_DOZEN = 12;
         System.out.print("Enter price of an item: ");
         itemPrice = input.nextFloat();
         System.out.print("Enter sales tax as decimal(exe. .0735): ");
         TOTAL_SALES_TAX = input.nextFloat();
         itemTotal = 0F;
         System.out.print("Enter a radius for a circle: ");
         totalRadius = input.nextInt();
         PI = 3.14159265359;
         totalArea = 0;
         System.out.print("Enter the amount of hits: ");
         totalHits = input.nextInt();
         System.out.print("Enter the total amount of at bats: ");
         totalAtBats = input.nextInt();
         totalBatAvg = 0F;
         System.out.print("Enter an integer: ");
         Widget1 = input.nextInt();
         System.out.print("Enter another integer: ");
         Widget2 = input.nextInt();
         addWidget2 = 45;
         
         // Computations: computations, algorithms
         // Outputs: outputs, formatting, display
         
         // problem 1 total price of lunch
         totalPrice = priceSandwich + priceChips + priceSoda;
         System.out.println("1) Lunch price is:\t\t\t\t\t\t\t" + "$" 
                            + totalPrice + "\n");
         // problem 2 total full one-dozen egg cartons
         fullOneDozen = totalEggs / ONE_DOZEN;
         System.out.println("2) " + totalEggs + " eggs fills:\t\t\t\t\t\t\t" 
                            + fullOneDozen + " cartons" + "\n");
         // problem 3 total leftover eggs
         leftOverDozen = totalEggs % ONE_DOZEN;
         System.out.println("3) " + totalEggs + " eggs leaves:\t\t\t\t\t\t\t" 
                            + leftOverDozen + " eggs" + "\n");
         // problem 4 total sales tax on item
         itemTotal = itemTotal + (itemPrice * TOTAL_SALES_TAX);
         System.out.println("4) " + TOTAL_SALES_TAX + " tax on " + itemPrice + " is:\t\t\t\t\t" 
                            + "$"  + itemTotal + "\n");
         // problem 5 total area of a circle
         totalArea = PI * (totalRadius*totalRadius);
         System.out.println("5) r=" + totalRadius + " circle area is:\t\t\t\t\t" 
                            + totalArea + "\n");
         // problem 6 total batting average for a baseball game
         totalBatAvg = ((float)totalHits/totalAtBats);
         System.out.println("6) " + totalHits + " hits, " + totalAtBats + " at-bats batting avg is:\t" 
                            + totalBatAvg + "\n");
         // problem 7 quantity for Widget1
         // see below 
         System.out.println("7a) Widget1 inventory before:\t\t\t\t" 
                            + Widget1--);
         System.out.println("7b) Widget1 inventory after:\t\t\t\t" 
                            + Widget1 + "\n");
         // probem 8 quantity for Widget2
         // see below
         System.out.println("8a) Widget2 inventory before:\t\t\t\t" 
                            + Widget2);
         System.out.println("8b) Widget2 inventory after:\t\t\t\t"
                             + (Widget2+=addWidget2) + "\n");
     
    }
      
