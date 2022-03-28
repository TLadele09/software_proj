
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
public class WorldAndRides

    //TODO decide a proper data-structure to store the information about the world
    //and the requested rides.

{
    ArrayList<Rides> rides;
    //For the World
    int numOfRows;
    int numOfCols;
    int numOfCars;
    int numOfRides;
    int numOfBonusPoints;
    int numOfSteps;
    public WorldAndRides(String worldAndRidesFileName) throws FileFormatException {
        //TODO read the world information from worldAndRidesFileName
        //and store the information in this class
        rides = new ArrayList<Rides>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(worldAndRidesFileName));
            String line = reader.readLine();
            String[] world = line.split(" ");
            int[] worldInt = new int[world.length];
            for(int i = 0; i < world.length; i++){
                worldInt[i] = Integer.parseInt(world[i]);
            }
            numOfRows = worldInt[0];
            numOfCols = worldInt[1]; 
            numOfCars = worldInt[2];
            numOfRides = worldInt[3];
            numOfBonusPoints = worldInt[4];
            numOfSteps = worldInt[5];
            //System.out.println(numOfRows + ", " + numOfCols + ", " + numOfCars + ", " + numOfRides + ", " + numOfBonusPoints + ", " + numOfSteps);
            List<String> ls = new ArrayList<String>();
            while((line=reader.readLine())!=null){
                ls.add(line);
            }
            //Rides eachRide = new Rides();
            int rideID = 0;
            for(String word : ls) {
                String[] strArray = word.split(" ");
                int[] intArray = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++){
                    intArray[i] = Integer.parseInt(strArray[i]);
                }
                //store parameters each ride
                rides.add(new Rides(rideID,intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5]));
                rideID++;
                //System.out.println(Arrays.toString(intArray));
            }
            
            for(int j = 0; j < rides.size(); j++){
                System.out.println(rides.get(j));
            }
            //sort earliest start
            Collections.sort(rides, new sortEarliestStartRides());
            System.out.println("\n------ Sorted List: By Earliest Start -------");
            for(int j = 0; j < rides.size(); j++){
                System.out.println(rides.get(j));
            }
            //sort Latest Finish
            Collections.sort(rides, new sortLatestFinishRides());
            System.out.println("\n------ Sorted List: By Latest Finish -------");
            for(int j = 0; j < rides.size(); j++){
                System.out.println(rides.get(j));
            }
            //System.out.println(rides.toString());
            reader.close();
        } catch (FileNotFoundException e) {
             System.out.println("ERROR: File not found");
        } catch(IOException e) {
            
        } 
        //TODO read the information about the requested rides and store the
        //information in this class
        // 2 2 1
    }
    
    public void sortEarliest(){
        Collections.sort(rides, new sortEarliestStartRides());
    }
    
    public void sortLatest(){
        Collections.sort(rides, new sortLatestFinishRides());
    }
    //TODO define appropriate methods for this class.
    public int getNumOfRows(){
        return numOfRows;
    }
    
    public int getNumOfCols(){
        return numOfCols;
    }
    
    public int getNumOfCars(){
        return numOfCars;
    }
    
    public int getNumOfRides(){
        return numOfRides;
    }
    
    public int getNumOfBonusPoints(){
        return numOfBonusPoints;
    }
    
    public int getNumOfSteps(){
        return numOfSteps;
    }
    
    public Rides getRideIndex(int id) {
        return rides.get(id);
    }
    
    public int getRideRowStart(){
        int rowStartInt = 0;
        for(Rides ride : rides){
            rowStartInt = ride.getRowOfStartInt();
        }
        return rowStartInt;
    }
    
    public int getRideColStart(){
        int colStartInt = 0;
        for(Rides ride : rides){
            colStartInt = ride.getColOfStartInt();
        }
        return colStartInt;
    }
    
    public int getRideRowFinish(){
        int rowFinishInt = 0;
        for(Rides ride : rides){
            rowFinishInt = ride.getRowOfFinishInt();
        }
        return rowFinishInt;
    }
    
    public int getRideColFinish(){
        int colFinishInt = 0;
        for(Rides ride : rides){
            colFinishInt = ride.getColOfFinishInt();
        }
        return colFinishInt;
    }
    
    public int getRideEarliestStart(){
        int earliestStartInt = 0;
        for(Rides ride : rides){
            earliestStartInt = ride.getEarliestStart();
        }
        return earliestStartInt;
    }
    
    public int getRideLatestFinish(){
        int latestFinishInt = 0;
        for(Rides ride : rides){
            latestFinishInt = ride.getLatestFinish();
        }
        return latestFinishInt;
    }    
}