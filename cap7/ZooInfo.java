import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.System.*;

public class ZooInfo {
  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
    
      out.println("begin");
      service.execute(() -> out.println("Printing zoo inventory"));
      service.execute(() -> { for(int i = 0; i < 300; i++) out.println("Printing record: " + i);});
      service.execute(() -> { for(int i = 0; i < 500; i++) out.println("Printing number: " + i);});
      service.execute(() -> out.println("Printing zoo inventory"));
      System.out.println("end");
    } finally {
      if(service != null) service.shutdown();
    }
  }
}
