/*
 * Name:       Blaze Halderman
 *
 * Course:     CS-12 Fall 2018
 *
 * Date:       12/1/18
 *
 * Filename:   SimulationBH1.java
 *
 * Purpose:    Automating traffic management using arrays
 */

public class SimulationBH1     {

    public static void main(String [] args)     {
    
        /* Data: variables setup, constants, user inputs
        (separate lines, if you wish)*/
        final double TIME_SECONDS;
        double [] cityDistances = {3.4, 4.1, 2.5};
        double [] freeDistances = {4.7, 5.3};
        int [] freeSpeed = new int [2];
        int [] citySpeed = new int [2];
        int numIterations;
        int numCopy;
        String routeSpeed;
        double tripFreeTotal;
        double tripCityTotal;
        double percentRouteFree;
        double percentRouteCity;
        double percentRouteToss;
        int freeInt;
        int cityInt;
        int tossInt;
        
        numIterations = UtilsBH1.readInt("How many simulation iterations? > ", false);
        numCopy = 1;
        tripFreeTotal = 0;
        tripCityTotal = 0;
        percentRouteFree = 0;
        percentRouteCity = 0;
        percentRouteToss = 0;
        freeInt = 0;
        cityInt = 0;
        tossInt = 0;
        
        // initializing 12 arrays based on iterations
        int [] ranFreeSpeed1 = new int [numIterations];
        int [] ranFreeSpeed2 = new int [numIterations];
        int [] ranCitySpeed1 = new int [numIterations];
        int [] ranCitySpeed2 = new int [numIterations];
        int [] ranCitySpeed3 = new int [numIterations];
        double [] timeFreeTravel1 = new double [numIterations];
        double [] timeFreeTravel2 = new double [numIterations];
        double [] timeCityTravel1 = new double [numIterations];
        double [] timeCityTravel2 = new double [numIterations];
        double [] timeCityTravel3 = new double [numIterations];
        double [] timeFreeTotal = new double [numIterations];
        double [] timeCityTotal = new double [numIterations];
        
        // prompt user for speed ranges
        freeSpeed[0] = UtilsBH1.readInt("Average freeway speed (min)? > ", false);
        freeSpeed[1] = UtilsBH1.readInt("Average freeway speed (max)? > ", false);
        citySpeed[0] = UtilsBH1.readInt("Average city speed (min)? > ", false);
        citySpeed[1] = UtilsBH1.readInt("Average city speed (max)? > ", false);
        TIME_SECONDS = 60;
        routeSpeed = "";
        
        // list iterations
        System.out.printf("\n");
        while(numCopy <= numIterations)    {
            System.out.printf("performing iteration %d ...\n", numCopy);
            numCopy += 1;
        }
        
        // Computations: computations, algorithms
        
        // calculate iterations
        for(int i = 0; i < numIterations; i++)   {
            // compute random speeds for travel segments
            ranFreeSpeed1[i] = UtilsBH1.randomInt(freeSpeed[0], freeSpeed[1]);
            ranFreeSpeed2[i] = UtilsBH1.randomInt(freeSpeed[0], freeSpeed[1]);
            ranCitySpeed1[i] = UtilsBH1.randomInt(citySpeed[0], citySpeed[1]);
            ranCitySpeed2[i] = UtilsBH1.randomInt(citySpeed[0], citySpeed[1]);
            ranCitySpeed3[i] = UtilsBH1.randomInt(citySpeed[0], citySpeed[1]);
            
            // compute travel time for each segments
            timeFreeTravel1[i] = (freeDistances[0]/ranFreeSpeed1[i]) * TIME_SECONDS;
            timeFreeTravel2[i] = (freeDistances[1]/ranFreeSpeed2[i]) * TIME_SECONDS;
            timeCityTravel1[i] = (cityDistances[0]/ranCitySpeed1[i]) * TIME_SECONDS;
            timeCityTravel2[i] = (cityDistances[1]/ranCitySpeed2[i]) * TIME_SECONDS;
            timeCityTravel3[i] = (cityDistances[2]/ranCitySpeed3[i]) * TIME_SECONDS;
        
            // compute overall travel time for each iteration
            timeFreeTotal[i] = timeFreeTravel1[i] + timeFreeTravel2[i];
            timeCityTotal[i] = timeCityTravel1[i] + timeCityTravel2[i] + timeCityTravel3[i];
        }
        
        // Outputs: outputs, formatting, display      
    
        // format data for city and freeway times and speeds
        System.out.printf("\n =================================================\n");
        System.out.printf(" TRAFFIC SIMULATION FOR %d ITERATIONS\n", numCopy-1);
        System.out.printf(" =================================================\n\n");
        System.out.printf(" LEGEND:   s=speed [MPH], t=time T=total time [mins] // f=freeway, c=city // #=iteration or segment\n\n");
        System.out.printf(" ###  sc1    tc1  sc2    tc2  sc3    tc3     sf1    tf1  sf2    tf2     Tcity   Tfwy fastest route\n");
        System.out.printf(" ===  ===  =====  ===  =====  ===  =====     ===  =====  ===  =====     =====  ===== =============\n");
        
        // check speed and calculate totals
        for(int i = 0; i < numIterations; i++)   {
            // if freeway is slower then city
            if(timeFreeTotal[i] > timeCityTotal[i])    {
                routeSpeed = "city faster";
                cityInt += 1;
            }
            // if city is slower then freeway
            else if(timeFreeTotal[i] < timeCityTotal[i])  {
                routeSpeed = "freeway faster";
                freeInt += 1;
            }
            // if both are same then they are same distance
            else    {
                routeSpeed = "tied";
                tossInt += 1;
            }
            System.out.printf("%4d%5d%7.2f%5d%7.2f%5d%7.2f%8d%7.2f%5d%7.2f%10.2f%7.2f%15s\n", i+1, ranCitySpeed1[i], timeCityTravel1[i], ranCitySpeed2[i], timeCityTravel2[i], ranCitySpeed3[i], timeCityTravel3[i], ranFreeSpeed1[i], timeFreeTravel1[i], ranFreeSpeed2[i], timeFreeTravel2[i], timeCityTotal[i], timeFreeTotal[i], routeSpeed);
        }
        
        // summary results - calculates route percentages and ranges
        System.out.printf("\n%32s%6.1f%6.1f%6.1f\n", "city travel segments [miles]:", cityDistances[0], cityDistances[1], cityDistances[2]);
        System.out.printf("freeway travel segments [miles]:%6.1f%6.1f\n", freeDistances[0], freeDistances[1]);
        System.out.printf("\n=======================================\n");
        System.out.printf("OVERALL SUMMARY OF RESULTS\n");
        System.out.printf("=======================================\n");
        System.out.printf("\n%d trips taken\n", numIterations);
        
        // calculate total distance
        for(int i = 0; i < cityDistances.length; i++)   {
            tripCityTotal += cityDistances[i];
        }
        System.out.printf("%8.1f city miles, speed range %d-%d MPH\n", tripCityTotal, citySpeed[0], citySpeed[1]);
        for(int i = 0; i < freeDistances.length; i++)   {
            tripFreeTotal += freeDistances[i];
        }
        System.out.printf("%8.1f  fwy miles, speed range  %d-%d MPH\n", tripFreeTotal, freeSpeed[0], freeSpeed[1]);
        
        // prints percentage values of route rates
        percentRouteCity = ((double)cityInt/numIterations)*100;
        System.out.printf("\n%s%8d/%d times (%5.2f%%)\n", "city route faster", cityInt, numIterations, percentRouteCity);
        percentRouteFree = ((double)freeInt/numIterations)*100;
        System.out.printf("%17s%8d/%d times (%5.2f%%)\n", "fwy route faster", freeInt, numIterations, percentRouteFree);
        percentRouteToss = ((double)tossInt/numIterations)*100;
        System.out.printf("%17s%8d/%d times (%5.2f%%)\n", "a toss up", tossInt, numIterations, percentRouteToss);
    }
      
}