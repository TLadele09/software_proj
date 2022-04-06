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
        int numOfCars = 0;
        int numOfRides = 0;
        //retrieve the ID of each Ride
        //add the ride id to the arraylist of the Car IDs
        worldAndRides.sortEarliest();
        int rideTocar = worldAndRides.rides.size()/worldAndRides.getNumOfCars();
        //System.out.println(rideTocar);
        carID = new ArrayList<Integer>();
        for(int i = 0; i < worldAndRides.rides.size(); i++){
            if(numOfCars < worldAndRides.getNumOfCars()){
                Rides ride = worldAndRides.rides.get(i);
                rID = ride.getRideID(); 
                if(carID.size() < rideTocar){
                    carID.add(rID);
                    numOfRides++;
                } else {
                    cars.add(new Cars(numOfRides, carID));
                    carID = new ArrayList<Integer>();
                    numOfRides = 0;
                    numOfCars++;
                }
            }
        }
    }

    public void printAllocation()
    {
        for(Cars car : cars) {
            if(car.getNumOfRides() != 0){
                System.out.print(car.getNumOfRides() + " ");
                for(int i = 0; i < car.ID.size(); i++){
                    System.out.print(car.ID.get(i) + " ");
                }
            }
            System.out.println();
        }
    }
}
