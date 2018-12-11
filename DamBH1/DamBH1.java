/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       11/09/18
 *
 * Filename:   DamBH1.java
 *
 * Purpose:    Class for generating dam objects with set specifications
 */

import java.util.Scanner;

public class DamBH1     {

    // instance variables
    private String name;
    private int year;
    private double storage;
    private double capacity;
    private double inflow;
    private double outflow;
    private CS12Date date;
    
    // constants
    
    // other class data
    
    // initialize variables
    
    // data above here
    
    // methods below here
    
    // constructors
    
    // default
    public DamBH1()    {
        this.name = "<default dam>";
        this.year = 1900;
        this.storage = 0.0;
        this.capacity = 0.0;
        this.inflow = 0.0;
        this.outflow = 0.0;
        this.date = new CS12Date();
    }
    
    // user enters all values
    public DamBH1(String name, int year, double storage, double capacity, double inflow, double outflow, CS12Date date)    {
        this.name = name;
        this.year = year;
        this.storage = storage;
        this.capacity = capacity;
        this.inflow = inflow;
        this.outflow = outflow;
        this.date = date;
    }
    
    // user enters name and year values
    public DamBH1(String name, int year) {
        this();
        this.name = name;
        this.year = year;
    }
    
    // user enters name and capacity
    public DamBH1(String name, double capacity) {
        this();
        this.name = name;
        this.capacity = capacity;
    }
    // display methods
    
    // toString method returns all instance variables, in a comma-seperated format
    public String toString()    {
        return (this.name + ", " + 
                this.year + ", " + 
                this.storage + ", " + 
                this.capacity + ", " + 
                this.inflow + ", " + 
                this.outflow + ", " + 
                this.date);
    }
    
    public void print()    {
        System.out.println("name:\t\t\t\t" + this.name);
        System.out.println("year:\t\t\t\t" + this.year);
        System.out.println("current date:\t\t" + this.date);
        System.out.println("storage [acre-ft]:\t" + this.storage);
        System.out.println("capacity [acre-ft]:\t" + this.capacity);
        System.out.println("inflow [cu-ft/s]:\t" + this.inflow);
        System.out.println("outflow [cu-ft/s]:\t" + this.outflow);
        //UtilsBH1.pause();
    }
    
    public void print(String message)   {
        System.out.print(message);
        print();
       // UtilsBH1.pause();
    }
    
    // accessors, mutators
    // get method for name of dam
    public String getName() {
        return this.name;
    }
    
    // sets the current name of dam
    public void setName(String name)   {
        this.name = name;
    }
    
    // sets the name of the dam, using user input
    public void setName(boolean mode)   {
        this.name = UtilsBH1.readString("Enter new dam name: ", mode);
        System.out.println("get - name is set to: " + this.name + "\n");
    }
    
    // get method for year of dam
    public int getYear()    {
        return this.year;
    }
    
    // sets the current year of dam
    public void setYear(int year)   {
        this.year = year;
    }
    
    // sets the year of the dam, using user input
    public void setYear(boolean mode)   {
        this.year = UtilsBH1.readInt("Enter new dam year: ", mode);
        System.out.println("get - year is set to: " + this.year + "\n");
    }
    
    // get method for storage of dam
    public double getStorage()  {
        return this.storage;
    }
    
    // sets the current storage of dam
    public void setStorage(double storage)    {
        this.storage = storage;
    }
    
    // sets the storage of the dam, using user input
    public void setStorage(boolean mode)    {
        this.storage = UtilsBH1.readDouble("Enter new water storage amount [acre-ft]: ", mode);
        System.out.println("get - storage is set to: " + this.storage + "\n");
    }
    
    // get method for capacity of dam
    public double getCapacity() {
        return this.capacity;
    }
    
    // sets the current capacity of dam
    public void setCapacity(double capacity)   {
        this.capacity = capacity;
    }
    
    // sets the capacity of the dam, using user input
    public void setCapacity(boolean mode)   {
        this.capacity = UtilsBH1.readDouble("Enter new water capacity amount [acre-ft]: ", mode);
        System.out.println("get - capacity is set to: " + this.capacity + "\n");
    }
    
    // get method for inflow of dam
    public double getInflow()   {
        return this.inflow;
    }
    
    // sets the current inflow of dam
    public void setInflow(double inflow) {
        this.inflow = inflow;
    }
    
    // sets the inflow of the dam, using user input
    public void setInflow(boolean mode) {
        this.inflow = UtilsBH1.readDouble("Enter new water inflow rate amount [cu-ft/sec]: ", mode);
        System.out.println("get - inflow is set to: " + this.inflow + "\n");
    }
    
    // get method for outflow of dam
    public double getOutflow() {
        return this.outflow;
    }
    
    // sets the current outflow of dam
    public void setOutflow(double outflow)  {
        this.outflow = outflow;
    }
    
    // sets the outflow of the dam, using user input
    public void setOutflow(boolean mode)    {
        this.outflow = UtilsBH1.readDouble("Enter new water outflow rate amount [cu-ft/sec]: ", mode);
        System.out.println("get - outflow is set to: " + this.outflow + "\n");
    }
    
    // get method for date of dam
    public CS12Date getDate()   {
        return this.date;
    }
    
    // sets the current date of dam
    public void setDate(CS12Date date)    {
        this.date = date;
    }
    
    public void setDate(boolean mode)   {
        this.date.setMonth(UtilsBH1.readInt("Enter a new month for the dam date: ", mode));
        this.date.setDay(UtilsBH1.readInt("Enter a new day for the dam date: ", mode));
        this.date.setYear(UtilsBH1.readInt("Enter a new year for the dam date: ", mode));
        System.out.println("get - date is set to: " + this.date + "\n");
    }
    
    
    // equivalance
    public boolean equals(DamBH1 obj) {
        boolean objState;
        
        objState = true;
        
        if (!(obj.name == this.name))   {
            objectState = false;
        }
        else if (!(obj.year == this.year))  {
            objState = false;
        }
        else if (!(obj.storage == this.storage))   {
            objState = false;
        }
        else if (!(obj.capacity == this.capacity))   {
            objState = false;
        }
        else if (!(obj.inflow == this.inflow))   {
            objState = false;
        }
        else if (!(obj.outflow == this.outflow))  {
            objState = false;
        }
        else if (!(this.date.equals(obj.date)))  {
            objState = false;
        }
        if (objState == false)
            return false;
        return true;
    }
    
    
    // derived data accessors
    
    //utility methods
    
    // end class

    public static void main(String [] args)     {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
        DamBH1 first = new DamBH1();
        DamBH1 second = new DamBH1();
        CS12Date newDate = new CS12Date();
        DamBH1 third = new DamBH1("Empire", 2001, 500000.00, 1000000.00, 3000.00, 1000.00, newDate);
        DamBH1 fourth = new DamBH1("Field", 1765);
        DamBH1 fifth = new DamBH1("Body", 1000000.00);
        
        
        // Outputs: outputs, formatting, display
        System.out.print("====================================\n" +
        "Test for 4 constructor forms using \ntoString() and print() methods\n" +
        "====================================\n");
        // test for default constructor method
        System.out.println("\nDefault class constructor method\n" + "====================================");
        System.out.println("method for toString(): " + first.toString() + "\n");
        first.print();
        UtilsBH1.pause();
        // test for second constructor method
        System.out.println("\nDam object class using second constructor method\n" + "====================================");
        System.out.println("method for toString(): " + third.toString() + "\n");
        third.print();
        UtilsBH1.pause();
        // test for third constructor method
        System.out.println("\nDam object class using third constructor method\n" + "====================================");
        System.out.println("method for toString(): " + fourth.toString() + "\n");
        fourth.print();
        UtilsBH1.pause();
        // test for fourth constructor method
        System.out.println("\nDam object class using fourth constructor method\n" + "====================================");
        System.out.println("method for toString(): " + fifth.toString() + "\n");
        fifth.print();
        UtilsBH1.pause();
        // test for accessor and mutator methods
        first.print("====================================\n" +
        "Tests for all accessors and mutators\n" + 
        "====================================\n\n" +
        "====================================\n" +
        "New default damBH1\n" +
        "====================================\n");
        // sets name using command line
        first.setName(false);
        // sets year using command line
        first.setYear(false);
        // sets storage using command line
        first.setStorage(false);
        // sets capacity using command line
        first.setCapacity(false);
        // sets inflow using command line
        first.setInflow(false);
        // sets outflow using command line
        first.setOutflow(false);
        // sets date using command line
        first.setDate(false);
        
        first.print("====================================\n" +
        "Updated dam reflecting above changes\n" + 
        "====================================\n");
        // compares dam object to itself
        System.out.println("Dam should equal itself:\t\t\t\t" + second.equals(second));
        // compares dam object to another dam object
        System.out.println("Two different dams should not equal:\t" + first.equals(second));
        // compares dam object to a string
        System.out.println("Dam and String should not be equal:\t\t" + first.equals("string"));
        // compares dam object to a CS12Date date
        System.out.println("Dam and CS12Date not equal:\t\t\t\t" + first.equals(newDate));
    }
      
}
