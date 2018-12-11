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
        this();
        
        setName(name);
        setYear(year);
        setCapacity(capacity);
        setStorage(storage);
        setInflow(inflow);
        setOutflow(outflow);
        setDate(date);
    }
    
    // user enters name and year values
    public DamBH1(String name, int year) {
        this();
        setName(name);
        setYear(year);
    }
    
    // user enters name and capacity
    public DamBH1(String name, double capacity) {
        this();
        setName(name);
        setCapacity(capacity);
    }
    
    // display methods
    
    // toString method returns all instance variables, in a comma-seperated format
    public String toString()    {
        return (this.name + 
                String.format("%7d", (long)this.year) + 
                String.format("%,8d", (long)this.storage) + 
                String.format("%,12d", (long)this.capacity) + 
                String.format("%,7d", (long)this.inflow) + 
                String.format("%,9d", (long)this.outflow) + 
                String.format("%14s", this.date) + "\n");
    }
    
    public void print()    {
        System.out.println("name:\t\t\t" + this.name);
        System.out.println("year:\t\t\t\t\t" + this.year);
        System.out.println("current date:\t\t\t" + this.date);
        System.out.println("storage [acre-ft]:\t\t" + String.format("%,d", (long)this.storage));
        System.out.println("capacity [acre-ft]:\t\t" + String.format("%,d" , (long)this.capacity));
        System.out.println("inflow [cu-ft/s]:\t\t" + String.format("%,d" , (long)this.inflow));
        System.out.println("outflow [cu-ft/s]:\t\t" + String.format("%,d" , (long)this.outflow));
        System.out.println("age [yrs]:\t\t\t\t" + this.getAge());
        System.out.println("status:\t\t\t\t\t" + this.getStatus());
        System.out.println("% full:\t\t\t\t\t" + String.format("%.1f %%", this.getPercentFull()));
        System.out.println("days until dam event:\t" + this.getEventDays());
        System.out.println("date of dam event:\t\t" + this.getEventDate());
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
        if (year < 1900)    {
            System.out.println("ERROR: year must be >= 1900, value unchanged");
        }
        else    {
            this.year = year;
        }
    }
    
    // sets the year of the dam, using user input
    public void setYear(boolean mode)   {
        int year;
        
        year = UtilsBH1.readInt("Enter new dam year: ", mode);
        if (year < 1900)    {
            System.out.println("ERROR: year must be >= 1900, value unchanged");
        }
        else    {
            this.year = year;
        }
    }
    
    // get method for storage of dam
    public double getStorage()  {
        return this.storage;
    }
    
    // sets the current storage of dam
    public void setStorage(double storage)    {
        if (storage < 0.0 || storage > this.capacity)   {
            System.out.println("ERROR: storage must be >= 0 acre-feet, value unchaned");
        }
        else    {
            this.storage = storage;
        }
    }
    
    // sets the storage of the dam, using user input
    public void setStorage(boolean mode)    {
        double storage;
        
        storage = UtilsBH1.readDouble("Enter new water storage amount [acre-ft]: ", mode);
        if (storage < 0.0 || storage > this.capacity)   {
            System.out.println("ERROR: storage must be >= 0 acre-feet, value unchaned");
        }
        else    {
            this.storage = storage;
        }
    }
    
    // get method for capacity of dam
    public double getCapacity() {
        return this.capacity;
    }
    
    // sets the current capacity of dam
    public void setCapacity(double capacity)   {
        if (capacity < 0.0 || capacity < this.storage)   {
            System.out.println("ERROR: capacity must be >= 0 acre-feet, value unchanged");
        }
        else    {
            this.capacity = capacity;
        }
    }
    
    // sets the capacity of the dam, using user input
    public void setCapacity(boolean mode)   {
        double capacity;
    
        capacity = UtilsBH1.readDouble("Enter new water capacity amount [acre-ft]: ", mode);
        if (capacity < 0.0 || capacity < this.storage)   {
            System.out.println("ERROR: capacity must be >= 0 acre-feet, value unchanged");
        }
        else    {
            this.capacity = capacity;
        }
    }
    
    // get method for inflow of dam
    public double getInflow()   {
        return this.inflow;
    }
    
    // sets the current inflow of dam
    public void setInflow(double inflow) {
        if (inflow < 0.0)   {
            System.out.println("ERROR: inflow must be >= 0 cu-ft/sec, value unchanged");
        }
        else    {
            this.inflow = inflow;
        }
    }
    
    // sets the inflow of the dam, using user input
    public void setInflow(boolean mode) {
        double inflow;
        
        inflow = UtilsBH1.readDouble("Enter new water inflow rate amount [cu-ft/sec]: ", mode);
        if (inflow < 0.0)   {
            System.out.println("ERROR: inflow must be >= 0 cu-ft/sec, value unchanged");
        }
        else    {
            this.inflow = inflow;
        }
    }
    
    // get method for outflow of dam
    public double getOutflow() {
        return this.outflow;
    }
    
    // sets the current outflow of dam
    public void setOutflow(double outflow)  {
        if (outflow < 0.0)   {
            System.out.println("ERROR: outflow must be >= 0 cu-ft/sec, value unchanged");
        }
        else    {
            this.outflow = outflow;
        }
    }
    
    // sets the outflow of the dam, using user input
    public void setOutflow(boolean mode)    {
        double outflow;
        
        outflow = UtilsBH1.readDouble("Enter new water outflow rate amount [cu-ft/sec]: ", mode);
        if (outflow < 0.0)   {
            System.out.println("ERROR: outflow must be >= 0 cu-ft/sec, value unchanged");
        }
        else    {
            this.outflow = outflow;
        }
    }
    
    // get method for date of dam
    public CS12Date getDate()   {
        CS12Date temp = new CS12Date();
        temp.setMonth(this.date.getMonth());
        temp.setDay(this.date.getDay());
        temp.setYear(this.date.getYear());
        return (temp);
    }
    
    // sets the current date of dam
    public void setDate(CS12Date date)    {
        (this.date).setMonth(date.getMonth());
        (this.date).setDay(date.getDay());
        (this.date).setYear(date.getYear());
    }
    
    // sets the current date of dam using user input mode
    public void setDate(boolean mode)   {
        this.date.setMonth(UtilsBH1.readInt("Enter a new month for the dam date: ", mode));
        this.date.setDay(UtilsBH1.readInt("Enter a new day for the dam date: ", mode));
        this.date.setYear(UtilsBH1.readInt("Enter a new year for the dam date: ", mode));
    }
    
    
    // equivalance
    public boolean equals(DamBH1 obj) {
        boolean objState;
        
        objState = true;
        
        // logic comparing two dam objects
        if (!(obj.name == this.name))   {
            objState = false;
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
    
    // getting the age of a specified dam
    public int getAge() {
        CS12Date currYear;
        int year;
        int damAge;
        
        year = this.getYear();
        currYear = new CS12Date(1, 1, year);
        
        // compares two dates(the current date with the damn start date) to get age
        damAge = UtilsBH1.getAge(currYear, this.getDate());
        return (damAge);
    }
    
    // get dams current status based on inflow, outflow, storage and capacity
    public String getStatus()   {
        String damStatus;
        
        // if inflow is greater then outflow, filling
        if (this.inflow > this.outflow)   {
            damStatus = "Filling";
        }
        // if inflow is less then outflow, emptying
        else if (this.inflow < this.outflow)  {
            damStatus = "Emptying";
        }
        // else the two equal, its holding
        else  {
            damStatus = "Holding";
        }
        return damStatus;
    }
    
    // gets a dams current percentage ratio of storage and capacity
    public double getPercentFull()  {
        double damPercent;
        
        // if the capacity is greater then 0, generate a percent
        if (this.capacity > 0.0)   {
            damPercent = (storage/capacity)*100;
        }
        // if not greater than 0 output 0
        else    {
            damPercent = 0.0;
        }
        return (damPercent);
    }
    
    // gets a dams number of days until an event
    public int getEventDays()   {
        double damTime;
        final double CUFT_PER_ACREFT;
        final double SECS_PER_HR;
        final double HRS_PER_DAY;
        final double TO_DAYS;
        
        CUFT_PER_ACREFT = 43560;
        SECS_PER_HR = 3600;
        HRS_PER_DAY = 24;
        TO_DAYS = ((CUFT_PER_ACREFT/1)*(1/SECS_PER_HR)*(1/HRS_PER_DAY));
        // if status is filling do conversion for days
        if (this.getStatus() == "Filling")   {
            damTime = (((this.capacity - this.storage)/(this.inflow - this.outflow))*(TO_DAYS));
        }
        // if status is emptying do conversion for days
        else if (this.getStatus() == "Emptying")  {
            damTime = (((0 - this.storage)/(this.inflow - this.outflow))*(TO_DAYS));
        }
        // if status is holding return -1
        else    {
            return (-1);
        }
        return ((int)Math.floor(damTime));
    }
    
    // gets a dams current event date
    public CS12Date getEventDate()  {
        // create a temporary dam obj
        CS12Date temp = new CS12Date();
        
        // if status is holding and event days returns -1 add 100 years
        temp.setMonth(this.date.getMonth());
        temp.setDay(this.date.getDay());
        temp.setYear(this.date.getYear());
        
        if (this.getStatus() == "Holding" && this.getEventDays() == -1)  {
            temp.setYear(temp.getYear() + 100);
            return (temp);
        }
        // else any other status, add the event days
        else    {
            temp.laterDate(this.getEventDays());
            return (temp);
        }
    }
    
    //utility methods
    
    // updates current dam object using user input modes
    public void update(boolean mode)   {
        setName(mode);
        setYear(mode);
        setCapacity(mode);
        setStorage(mode);
        setInflow(mode);
        setOutflow(mode);
        setDate(mode);
    }
    
    // add water using a specific amount in acrefeet
    public void importWater(double acreFeet)    {
        // if requested change amount <= 0.0, do not make changes, error message
        if (acreFeet <= 0.0 || this.storage == 0)   {
            System.out.println("ERROR: enter a value that >= 0.0 or storage is 0");
        }
        // The storage cannot exceed the capacity or drop, outflow below 0.0
        else if ((this.storage + acreFeet) > this.capacity)  {
            System.out.println("ERROR: entered amount exceeds capacity, enter smaller value");
        }
        // safely make requested change, using corresponding non-prompting mutator
        else    {
            this.storage += acreFeet;
        }
    }
    
    // release water using a specific amount in acrefeet
    public void releaseWater(double acreFeet)  {
        // if requested change amount <= 0.0, do not make changes, error message
        if (acreFeet <= 0.0 || this.storage == 0)   {
            System.out.println("ERROR: enter a value that >= 0.0 or storage is 0");
        }
        // The storage cannot exceed the capacity or drop, outflow below 0.0
        else if ((this.storage - acreFeet) < 0.0)  {
            System.out.println("ERROR: entered amount causes storage exceed below 0, enter smaller value");
        }
        // safely make requested change, using corresponding non-prompting mutator
        else    {
            this.storage -= acreFeet;
        }
    }
    
    // increase outflow amount using cuFtSec
    public void increaseOutflow(double cuFtSec) {
        // if requested change amount <= 0.0, do not make changes, error message
        if (cuFtSec <= 0.0 || this.storage == 0)   {
            System.out.println("ERROR: enter a value that >= 0.0 or storage is 0");
        }
        // The storage cannot exceed the capacity or drop, outflow below 0.0
        else if ((this.outflow + cuFtSec) > this.storage)  {
            System.out.println("ERROR: Outflow exceeds storage, enter smaller value");
        }
        // safely make requested change, using corresponding non-prompting mutator
        else    {
            this.outflow += cuFtSec;
        }
    }
    
    // decrease outflow amount using cuFtSec
    public void decreaseOutflow(double cuFtSec)   {
        // if requested change amount <= 0.0, do not make changes, error message
        if (cuFtSec <= 0.0 || this.storage == 0)   {
            System.out.println("ERROR: enter a value that >= 0.0");
        }
        // The storage cannot exceed the capacity or drop, outflow below 0.0
        else if ((this.outflow - cuFtSec) < 0.0)  {
            System.out.println("ERROR: Outflow exceeds below 0, enter a smaller value");
        }
        // safely make requested change, using corresponding non-prompting mutator
        else    {
            this.outflow -= cuFtSec;
        }
    }
    
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
