import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class AddData {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      Future<Integer> result = service.submit(() -> 30 + 12);
      System.out.println(result.get());
    } finally {
      if(service != null) service.shutdown();
    }
  }
}
