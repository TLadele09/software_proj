import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
/**
 * Write a description of class Simulation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Simulation
{
   String worldAndRidesFileName;
   String allocationFileName;
   public Simulation(String worldAndRidesFileName, String allocationFileName) {
       this.worldAndRidesFileName = worldAndRidesFileName;
       this.allocationFileName = allocationFileName;
   }
    
   public void run() {
       try {
           WorldAndRides worldAndRides = new WorldAndRides(worldAndRidesFileName);
           Allocation allocation = new Allocation(allocationFileName, worldAndRides);
           
           //rides = new ArrayList<Rides>();
           //score for simulation
           int score = 0;
           //world components 
           int worldRows = worldAndRides.getNumOfRows();
           int worldCols = worldAndRides.getNumOfCols();
           int worldCars = worldAndRides.getNumOfCars();
           int worldRides = worldAndRides.getNumOfRides();
           int worldBonusPoints = worldAndRides.getNumOfBonusPoints();
           int worldSteps = worldAndRides.getNumOfSteps();
           int drivetoStart = 0;
           int drivetoFinish = 0;
           int rideLength = 0;
           //For each ride
           int[][] world = new int[worldRows][worldCols];
           int []startPoint = new int[2];
           int []finishPoint = new int[2];
           startPoint[0] = worldAndRides.getRideRowStart();
           startPoint[1] = worldAndRides.getRideRowFinish();
           finishPoint[0] = worldAndRides.getRideColStart();
           finishPoint[1] = worldAndRides.getRideColFinish();
           //for every car that exists
           //need to get list of rides that the car needs to do
           //then simulate what every car needs to do
           int rideBonus = 0;
           for(Cars car: allocation.cars){
               int rideId = 0;
               int clock = 0;
               int startLength = 0;
               int []currentPos = {0,0};
               for(int x = 0; x < car.id.size(); x++){
                   rideId = car.id.get(x);
                   Rides eachRide = worldAndRides.getRideIndex(rideId);
                   System.out.println(eachRide.toString());
                   int i = Math.abs(startPoint[1] - currentPos[1]);
                   int j = Math.abs(startPoint[0] - currentPos[0]);
                   startLength = i + j;
                   //currentPos[0] = j;
                   //currentPos[1] = i;
                   if(eachRide.getEarliestStart() >= startLength ){
                       rideBonus = eachRide.getEarliestStart() - startLength;
                       int f = Math.abs(finishPoint[1] - startPoint[1]);
                       int g = Math.abs(finishPoint[0] - startPoint[0]);
                       rideLength = f + g;
                       if(eachRide.getLatestFinish() >= rideLength) {
                           rideBonus = worldBonusPoints;
                           score = rideLength + rideBonus;
                           clock = startLength + rideLength;
                       } else {
                           rideBonus = 0;
                           score = rideLength;
                           clock = startLength + rideLength;
                       }
                   } else {
                       int f = Math.abs(finishPoint[1] - startPoint[1]);
                       int g = Math.abs(finishPoint[0] - startPoint[0]);
                       rideLength = f + g;
                       if(eachRide.getLatestFinish() >= startLength + rideLength) {
                           rideBonus = worldBonusPoints;
                           score = rideLength + rideBonus;
                           clock = startLength + rideLength;
                       } else {
                           rideBonus = 0;
                           score = rideLength;
                           clock = startLength + rideLength;
                       }
                   }
                   System.out.println(clock);
               }
           }
           System.out.println(score);
           //compute score of allocation
           //Each vehicle is allocated rides
       } catch (FileFormatException e) {
           System.out.println ("ERROR "+ e.description());
       }
   }
}
