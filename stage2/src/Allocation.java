import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.List;

public class Allocation
{
    ArrayList<Cars> cars;
    ArrayList<Integer> carID;
    public Allocation(WorldAndRides worldAndRides) throws FileFormatException 
    {
        cars = new ArrayList<Cars>();
        int rID = 0;
        //retrieve the ID of each Ride
        //add the ride id to the arraylist of the Car IDs
        for(int i = 0; i < worldAndRides.rides.size(); i++){
            Rides ride = worldAndRides.rides.get(i);
            int numOfRides = 0;
            carID = new ArrayList<Integer>();
            worldAndRides.sortEarliest();
            rID = ride.getRideID(); 
            carID.add(rID);
            numOfRides++;
            cars.add(new Cars(numOfRides, carID));
        }
    }

    public void printAllocation()
    {
        for(Cars car : cars) {
            System.out.print(car.getNumOfRides() + " ");
            for(int i = 0; i < car.ID.size(); i++){
                System.out.println(car.ID.get(i) + " ");
            }
            //System.out.print(car.getID());
        }
    }
}
