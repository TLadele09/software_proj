import java.util.Comparator;
import java.util.ArrayList;
public class Rides
{
    //For each ride
    int rowOfStartInt;
    int colOfStartInt;
    int rowOfFinishInt;
    int colOfFinishInt;
    int earliestStart;
    int latestFinish;
    int rideID;
    public Rides(int rowOfStartInt, int colOfStartInt, int rowOfFinishInt, int colOfFinishInt, int earliestStart, int latestFinish)
    {
        this.rowOfStartInt = rowOfStartInt;
        this.colOfStartInt = colOfStartInt;
        this.rowOfFinishInt = rowOfFinishInt;
        this.colOfFinishInt = colOfFinishInt;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public int getRowOfStartInt() {
        return rowOfStartInt;
    }
    
    public int getColOfStartInt() {
        return colOfStartInt;
    }
    
    public int getRowOfFinishInt() {
        return rowOfFinishInt;
    }
    
    public int getColOfFinishInt() {
        return colOfFinishInt;
    }
    
    public int getEarliestStart() {
        return earliestStart;
    }
    
    public int getLatestFinish() {
        return latestFinish;
    }
    
    @Override
    public String toString() {
        return(rowOfStartInt + " " + colOfStartInt + " " + rowOfFinishInt + " " + colOfFinishInt + " " + earliestStart + " " + latestFinish);
    }
}

class sortEarliestStartRides implements Comparator<Rides>{
    public int compare(Rides a, Rides b)
    {
        return a.earliestStart - b.earliestStart;
    }
}

class sortLatestFinishRides implements Comparator<Rides>{
    public int compare(Rides a, Rides b)
    {
        return a.latestFinish - b.latestFinish;
    }
}