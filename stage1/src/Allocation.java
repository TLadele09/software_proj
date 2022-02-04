import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.List;
/**
 * Write a description of class Allocation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Allocation

    //TODO decide a proper data-structure to store the allocation

{
    private ArrayList<Cars> cars;
    //For each Car
    public Allocation(String allocationFileName, WorldAndRides worldAndRides) throws FileFormatException {
        //TODO read an allocation from allocationFileName and stores the content in
        //an appropriate datastructure inside this class
        cars = new ArrayList<Cars>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(allocationFileName));
            String line = reader.readLine();
            List<String> ls = new ArrayList<String>();
            while((line=reader.readLine())!=null){
                ls.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
             System.out.println("ERROR: File not found");
        } catch(IOException e) {
            
        } 
    }
    
    //TODO define appropriate methods for this class (e.g. accessor methods)
}