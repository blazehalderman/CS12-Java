/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       09/28/18
 *
 * Filename:   CS12DateBH1.java
 *
 * Purpose:    Using API methods to solve problems in a separate class for dates
 */
import java.util.Scanner;

public class CS12DateClientBH1 {

    public static void main(String[] args) {
        // initializing object instances from CS12Date and variables
        Scanner input = new Scanner(System.in);
        int month;
        int day;
        int year;
        CS12Date today = new CS12Date();
        CS12Date halloween = new CS12Date(10,31,2018);
        CS12Date myBday = new CS12Date(11,1);
        CS12Date christmas = new CS12Date();
        
        System.out.println("1a) myDate1 explicitly with toString() = " + today.toString());
        System.out.println("1b) myDate1 explicitly = " + today);
        // using custom print method on CS12DateObject to print todays specific date
        today.print("2) This is default constructor date of today");
        // using custom print method on CS12DateObject to print halloween specific date
        halloween.print("3) Halloween using m-d-y constructor");
        // using custom print method on CS12DateObject to print birthday specific date
        myBday.print("4) Imaginary birthday using m-d constructor");
        // using setDate() method from the CS12Date object christmas to set a new date
        christmas.setDate(12, 25, 2018);
        System.out.println("5) Christmas using default constructor THEN setDate(): " + christmas + "\n");
        // using nextDate() method to skip a day at a time
        myBday.nextDate();
        myBday.nextDate();
        myBday.nextDate();
        System.out.println("6a) 3 days later using nextDate(): " + myBday);
        // using laterDate() to skip by a set number of days
        myBday.laterDate(7);
        System.out.println("6b) 1 week later using laterDate() : " + myBday);
        // using scanner get month, date, and year
        System.out.print("\nThis year's birthday month? >");
        month = input.nextInt();
        System.out.print("This year's birthday day? >");
        day = input.nextInt();
        System.out.print("This year's birthday year? >");
        year = input.nextInt();
        // set new birthdate using 3 mutator methods
        myBday.setDate(month, day, year);
        myBday.print("7) This year's birthday using mutators is/was:");
        // using date number method getDateNum() to find the day of the year
        System.out.println("\n8) This year's birthday " + myBday + " is/was day #: "+ myBday.getDateNum());
        // using the equals() to compare today to your birthday
        System.out.println("\n9) Is today " + today + " my birthday " + myBday + "? " + today.equals(myBday));
        // compare dates using compare() method
        System.out.println("\n10a) compare today to my birthday: " + today.compare(myBday));
        System.out.println("10b) compare my birthday to today: " + myBday.compare(today));
        System.out.println("10c) compare today to today: " + today.compare(today));
        // reset values to zero, and print out birthdate using get methods
        month = 0;
        day = 0;
        year = 0;
        System.out.println("\n11) This year's birthday with dashes is still: " + myBday.getMonth() + "-" + myBday.getDay() + "-" + myBday.getYear());
    }
}
