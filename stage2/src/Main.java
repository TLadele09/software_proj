import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
  public static void main(WorldAndRides args) throws FileFormatException {
    WorldAndRides worldAndRidesFileName = args;
    //modify the following to launch the allocation which would read the rides file and print 
    //the allocation to the standard output, e.g.
    Allocation a = new Allocation(worldAndRidesFileName);
    a.printAllocation();
  }
}