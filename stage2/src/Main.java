import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
  public static void main(String[] args) throws FileFormatException {
    String worldAndRidesFileName = args[0];
    //modify the following to launch the allocation which would read the rides file and print 
    //the allocation to the standard output, e.g.
    WorldAndRides w = new WorldAndRides(worldAndRidesFileName);
    Allocation a = new Allocation(w);
    a.printAllocation();
  }
}