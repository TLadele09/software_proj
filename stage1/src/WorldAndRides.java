import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;

/**
 * Write a description of class WorldAndRides here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldAndRides

    //TODO decide a proper data-structure to store the information about the world
    //and the requested rides.

{
    private ArrayList<Rides> rides;    
    public WorldAndRides(String worldAndRidesFileName) throws FileFormatException {
        //TODO read the world information from worldAndRidesFileName
        //and store the information in this class
        int numOfRows;
        int numOfCols;
        int numOfCars;
        int numOfRides;
        int numOfBonusPoints;
        int numOfSteps;
        rides = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(worldAndRidesFileName));
            String line = reader.readLine();
            String[] strArr = line.split(" ");
            int[] intArr = new int[strArr.length];
            for(int i = 0; i < strArr.length; i++){
                intArr[i] = Integer.parseInt(strArr[i]);
            }
            numOfRows = intArr[0];
            numOfCols = intArr[1];
            numOfCars = intArr[2];
            numOfRides = intArr[3];
            numOfBonusPoints = intArr[4];
            numOfSteps = intArr[5];
            while((line!=null)){
                for(int i = 0; i < numOfRides; i++){
                    
                }
            }
            for(Rides ride : rides) {
                //ride.getNumOfRows() = intArr[0];
            }
            
            reader.close();
            //System.out.println(Arrays.toString(intArr));
            System.out.println(numOfRows + ", " + numOfCols + ", " + numOfCars + ", " + numOfRides + ", " + numOfBonusPoints + ", " + numOfSteps);
        } catch (FileNotFoundException e) {
             System.out.println("ERROR: File not found");
        } catch(IOException e) {
            
        } 
        
        //TODO read the information about the requested rides and store the
        //information in this class
    }
    
    //TODO define appropriate methods for this class.
}
