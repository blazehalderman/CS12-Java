/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       10/14/18
 *
 * Filename:   InputOutputBH1.java
 *
 * Purpose:    A general template for all future java programs
 */
 
 import java.util.Scanner;
 import javax.swing.JOptionPane;

public class InputOutputBH1     {

    public static void main(String [] args)     {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
         
        Scanner input = new Scanner(System.in);     
        String namePlayer;
        int numAtBats;
        int numHits;
        float totalAvg;
        int toVoteRec;
        int toVoteCast;
        double toVoteResult;
        String voteStr1;
        String voteMultiLine;
         
        // Computations: computations, algorithms
        
        // get user input for two ints and a full name
        // print name and batting average
        System.out.print("Enter player full name: ");
        namePlayer = input.nextLine();
        System.out.print("Enter number of hits: ");
        numHits = input.nextInt();
        System.out.print("Enter number of at-bats: ");
        numAtBats = input.nextInt();
        totalAvg = (float) numHits/numAtBats;
        System.out.printf("\nBatting average for %s last season was: %.3f\n", namePlayer, totalAvg);      
    
        // prompt for 2 inputs and display a percentage using input dialogues
        toVoteRec = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter votes received:"));
        toVoteCast = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter votes cast:"));
        toVoteResult = (double) toVoteRec*100/toVoteCast;
        voteMultiLine = "Votes received: %d\nVotes cast: %d\nPercentage of support: %.2f%%";
        voteStr1 = String.format(voteMultiLine, toVoteRec, toVoteCast, toVoteResult);
        JOptionPane.showMessageDialog(null, voteStr1);
        
    }
      
}
