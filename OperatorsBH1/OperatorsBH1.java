/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       09/7/18
 *
 * Filename:   OperatorsBH1.java
 *
 * Purpose:    Using operators to manipulate data.
 */

public class OperatorsBH1     {

    public static void main(String [] args)     {
    
         /* Data: variables setup, constants, user inputs
         (separate lines, if you wish)*/
         
         // Declaring variables
         
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
         
         priceSandwich = 2.75F;
         priceChips = 1.50F;
         priceSoda = 1.00F;
         totalPrice = 0F;
         totalEggs = 798;
         ONE_DOZEN = 12;
         fullOneDozen = 0;
         leftOverDozen = 0;
         itemPrice = 129.99F;
         TOTAL_SALES_TAX = .0725F;
         itemTotal = 0F;
         totalRadius = 2.8;
         PI = 3.14159265359;
         totalArea = 0;
         totalHits = 128;
         totalAtBats = 357;
         totalBatAvg = 0F;
         Widget1 = 30;
         Widget2 = 25;
         addWidget2 = 45;
         
         // Computations: computations, algorithms
         
         // problem 1 total price of lunch
         totalPrice = priceSandwich + priceChips + priceSoda;
         
         // problem 2 total full one-dozen egg cartons
         fullOneDozen = totalEggs / ONE_DOZEN;
         
         // problem 3 total leftover eggs
         leftOverDozen = totalEggs % ONE_DOZEN;
         
         // problem 4 total sales tax on item
         itemTotal = itemTotal + (itemPrice * TOTAL_SALES_TAX);
         
         // problem 5 total area of a circle
         totalArea = PI * (totalRadius*totalRadius);
         
         // problem 6 total batting average for a baseball game
         totalBatAvg = ((float)128/357);
         
         // problem 7 quantity for Widget1
         // see below 
         
         // probem 8 quantity for Widget2
         // see below
         
         // Outputs: outputs, formatting, display
         System.out.println("1) Lunch price is:                        " + "$" 
                            + totalPrice + "\n");
         System.out.println("2) " + 798 + " eggs fills:                        " 
                            + fullOneDozen + " cartons" + "\n");
         System.out.println("3) " + 798 + " eggs leaves:                       " 
                            + leftOverDozen + " eggs" + "\n");
         System.out.println("4) tax on " + 129.99 + " is:                      " 
                            + "$"  + itemTotal + "\n");
         System.out.println("5) r=" + 2.8 + " circle area is:                  " 
                            + totalArea + "\n");
         System.out.println("6) " + 128 + " hits, " + 357 + " at-bats batting avg is:  " 
                            + totalBatAvg + "\n");
         System.out.println("7a) Widget1 inventory before:              " 
                            + Widget1--);
         System.out.println("7b) Widget1 inventory after:               " 
                            + Widget1 + "\n");
         System.out.println("8a) Widget2 inventory before:              " 
                            + Widget2);
         System.out.println("8b) Widget2 inventory after:               "
                             + (Widget2+=addWidget2) + "\n");     
    
    }
      
}
