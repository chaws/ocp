import java.util.List;
import java.util.ArrayList;

public class WhaleDataCalculator {

  public int processRecord(int input) {
    try { Thread.sleep(40); }
    catch(InterruptedException e) {}
    return input + 1;
  }

  public void processAllData(List<Integer> data) {
    data.stream().map(d -> processRecord(d)).count();
  }

  public void processAllDataParallel(List<Integer> data) {
    data.parallelStream().map(d -> processRecord(d)).count();
    // or data.stream().parallel().map(d -> processRecord(d)).count();
  }

  public static void main(String[] args) {
    WhaleDataCalculator calculator = new WhaleDataCalculator();

    // Define data
    List<Integer> data = new ArrayList<>();
    for(int i = 0; i < 100; i++) data.add(i);

    // Serial
    System.out.println("Starting serial");
    long start = System.currentTimeMillis();
    calculator.processAllData(data);
    double time = (System.currentTimeMillis() - start) / 1000.0;
    System.out.println("Serial completed in " + time + " seconds.");

    // Parallel
    System.out.println("Starting parallel");
    start = System.currentTimeMillis();
    calculator.processAllDataParallel(data);
    time = (System.currentTimeMillis() - start) / 1000.0;
    System.out.println("Parallel completed in " + time + " seconds.");
  }
}
