import java.util.ArrayList;

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
   //ArrayList<Rides> rides; 
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
           //For each ride
           int[][] world = new int[worldRows][worldCols];
           int startPoint = 0;
           int finishPoint = 0;
           //for every car that exists
           //need to get list of rides that the car needs to do
           //then simulate what every car needs to do 
           
           for(int i = 0; i < worldRows; i++) {
               for(int j = 0; j < worldCols; j++) {
                   for(Cars car: allocation.cars){
                       int carId = 0;
                       int rideId = 0;
                       for(int x = 0; i<car.id.size(); i++){
                           carId = car.id.get(x);
                           //for(int j = 0; j<worldAndRides.rides.size();j++){
                              // rideId = worldAndRides.rides.get(j);
                           //}
                           Rides eachRide = worldAndRides.getRideIndex(carId);
                           System.out.println(eachRide);
                       }
                   }
           
                   startPoint = world[worldAndRides.getRideRowStart()][worldAndRides.getRideColStart()];
                   finishPoint = world[worldAndRides.getRideRowFinish()][worldAndRides.getRideColFinish()];
               }
           }
           System.out.println(finishPoint);
           //compute score of allocation
           //Each vehicle is allocated rides
           System.out.println(score);
       } catch (FileFormatException e) {
           System.out.println ("ERROR "+ e.description());
       }
   }
}
