/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       12/4/18
 *
 * Filename:   DamReportBH1.java
 *
 * Purpose:    Read dam objects from a text file and store values
 */

import java.util.*;
import java.io.*;

public class DamReportBH1     {
        
    // instance variables

    public static void main(String [] args)   {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
         
        char option;
        String menuOptions;
        int count;
        final int MAX_DAMS = 50;
        DamBH1 [] dams = new DamBH1[MAX_DAMS];
        
        dams[0] = new DamBH1();
        dams[1] = new DamBH1();
        dams[2] = new DamBH1();
        count = 0;
        // Computations: computations, algorithms
        
        // menu options
        menuOptions = "\nDAM OPTIONS:\nRead data from file\t\t[R]\nPrint dam summaries\t\t[S]\nPrint dam details\t\t[D]\nOverall water status\t[W]\nQuit\t\t\t\t\t[Q]\nEnter option > ";
        option = UtilsBH1.readChar(menuOptions, false);
        while ((option != 'Q') && (option != 'q'))    {
            switch (option) {
                case 'r':
                case 'R':
                    count = readDataFromFile(dams);
                    break;
                    
                case 's':
                case 'S':
                    printDamSummaries(dams, count);
                    break;
                
                case 'd':  
                case 'D':
                    printDamDetails(dams, count);
                    break;
                
                case 'w':
                case 'W':
                    showWaterStatus(dams, count);
                    break;

                default:
                    System.out.println("\nERROR: Unrecognized option " + option + 
                    ": please try again");
                    break;
            }
            option = UtilsBH1.readChar(menuOptions, false);
        }
        System.out.println("Exiting upon user request, goodbye!");       
        // Outputs: outputs, formatting, display       
    
    }
    
     // Methods
        
        // converts the string stored from file into dam object
        private static DamBH1 convertString2Dam(String data) {
            String [] dataDate;
            String [] dataDam;
            DamBH1 newDam = new DamBH1();
            CS12Date newDate = new CS12Date();
            
            // splitting, trimming, storing string
            dataDam = data.split(",");
            for (int i = 0; i < dataDam.length; i++) {
                dataDam[i] = dataDam[i].trim();
            }
            // iterate through date, separate contents into array
            dataDate = dataDam[6].split("/");
            for (int i = 0; i < dataDate.length; i++)  {
                dataDate[i] = dataDate[i].trim();
             }
             // setting values of dams with data index values
             newDam.setName(dataDam[0]);
             newDam.setYear(Integer.parseInt(dataDam[1]));
             newDam.setCapacity(Double.parseDouble(dataDam[3]));
             newDam.setStorage(Double.parseDouble(dataDam[2]));
             newDam.setInflow(Double.parseDouble(dataDam[4]));
             newDam.setOutflow(Double.parseDouble(dataDam[5]));
             
             // creates a new date object and sets the values
             newDate.setMonth(Integer.parseInt(dataDate[0]));
             newDate.setDay(Integer.parseInt(dataDate[1]));
             newDate.setYear(Integer.parseInt(dataDate[2]));
             newDam.setDate(newDate);
             
             return (newDam);        
        }
        
        // reads a file and returns the line count for creation of objects
        private static int readDataFromFile(DamBH1 [] dams) {
            String filename, text;
            int numLines;
            int currIndex;
            
            currIndex = 0;
            numLines = 0;
            // null all elements of array
            for (int i = 0; i < dams.length; i++) {
                dams[i] = null;
            }
            // read an input filename using utils
            filename = UtilsBH1.readString("Enter text file containing Dam data: ", false);
            
            // set up a second Sacanner to read from file
            try {
                File infile = new File(filename);
                Scanner fileInput = new Scanner(infile);
                
                // read and echo each line of file
                while(fileInput.hasNext()) {
                    text = fileInput.nextLine();
                    dams[currIndex] = convertString2Dam(text);
                    numLines++;
                    currIndex++;
                }
                // if amount read is less then 0, throw error
                if (currIndex < 0) {
                    System.out.println("ERROR: no Dams currently exist! Must add a valid Dam to file.");
                }
                // list amount of dams read
                else {
                    System.out.println("\n" + currIndex + " dams read from file: " + filename);
                }
            }
            // throw error if file cannot be opened
            catch (FileNotFoundException e) {
                System.out.println("Error: Cannot open file: " + filename);
            }
            return (numLines);
        }
        
        // prints a summary of dam results
        private static void printDamSummaries(DamBH1 [] dams, int count) {
            // if count dams are greater then 0
            if (count > 0) {
                // prints header
                System.out.printf("\n%-10s%6s%12s%12s%10s%10s%12s\n", "Name", "Year", "Storage", "Capacity", "Inflow", "Outflow", "Date");
                // loops over dam objects and prints contents
                for (int i = 0; i < count; i++) {
                    System.out.printf("%-10s%6d%,12.0f%,12.0f%,10.0f%,10.0f%4d/%2d/%2d\n", dams[i].getName(), dams[i].getYear(), dams[i].getStorage(), dams[i].getCapacity(), dams[i].getInflow(), dams[i].getOutflow(), dams[i].getDate().getMonth(), dams[i].getDate().getDay(), dams[i].getDate().getYear());
                }
            }
            // throws error otherwise
            else {
                System.out.println("\nERROR: no Dams currently exist! Must import from file.");
            }
        }
        
        // prints a detailed summary of dam results
        private static void printDamDetails(DamBH1 [] dams, int count) {
            // if count of dams are greater then 0
            if (count > 0) {
                // loops over dam objects and prints detailed info
                for (int i = 0; i < count; i++) {
                    dams[i].print("\n" + dams[i].getName() + "\n\n");
                }
            }
            // throws error otherwise
            else {
                System.out.println("\nERROR: no Dams currently exist! Must import from file.\n"); 
            }
        }
        
        // prints a detailed status of dams combined
        private static void showWaterStatus(DamBH1 [] dams, int count) {
            double storageNew;
            double capacityNew;
            double inflowNew;
            double outflowNew;
            int yearNew;
            DamBH1 superDam = new DamBH1();
            
            storageNew = 0.0;
            capacityNew = 0.0;
            inflowNew = 0.0;
            outflowNew = 0.0;
            yearNew = 0;
            // if dams count is more then 0
            if (count > 0) {
                // iterate through dam objects and add all values
                for (int i = 0; i < count; i++) {
                    storageNew += dams[i].getStorage();
                    capacityNew += dams[i].getCapacity();
                    inflowNew += dams[i].getInflow();
                    outflowNew += dams[i].getOutflow();
                }
                // set dam object values obtained
                superDam.setName("Super Dam");
                superDam.setYear(UtilsBH1.today().getYear());
                superDam.setCapacity(capacityNew);
                superDam.setStorage(storageNew);
                superDam.setInflow(inflowNew);
                superDam.setOutflow(outflowNew);
                superDam.print("\nOVERALL WATER HEALTH\n");
            }
            // throws error otherwise
            else {
                System.out.println("\nERROR: no Dams currently exist! Must import from file.\n");
            }
            
        }

      
}
