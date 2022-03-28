import java.util.List;
import java.util.ArrayList;
public class Cars
{
    //For each car
    // number of rides done by a specific car
    int numOfRides;
    //data structure to store id to specify each ride
    ArrayList<Integer> ID;
    /**
     * Constructor for objects of class Cars
     */
    public Cars(int numOfRides, ArrayList<Integer> ID)
    {
        this.numOfRides = numOfRides;
        this.ID = ID;
    }
    
    public Cars()
    {
        numOfRides = 0;
        ID = new ArrayList<>();
    }
    
    public int getNumOfRides()
    {
        return numOfRides;
    }

    public int getID(int index)
    {
        return ID.get(index);
    }
    
    public void printID()
    {
        for(int i = 0; i < ID.size(); i++){
            System.out.println(ID.get(i));
        }
    }
    
    @Override
    public String toString() {
        return(numOfRides + " " + ID);
    }
}