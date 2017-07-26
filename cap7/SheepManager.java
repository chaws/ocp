import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class SheepManager {
  private int sheepCount = 0;
  public void incrementAndReport() {
    System.out.print((++sheepCount) + " ");
  }

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(20);
      SheepManager manager = new SheepManager();
      for(int i = 0; i < 100; i++) {
        service.submit(() -> manager.incrementAndReport());
      }
    } finally {
      if(service != null) {
        service.shutdown();
      }
    }
  }
}
