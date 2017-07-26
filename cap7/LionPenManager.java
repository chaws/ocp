import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class LionPenManager {

  protected void removeAnimals() { System.out.println("Removing animals"); }
  protected void cleanPen() { System.out.println("Cleaning the pen"); }
  protected void addAnimals() { System.out.println("Adding animals"); }

  // To be implemented
  protected void performTask() {}

  public static void main(String[] args) {
    ExecutorService service = null;

    System.out.println("Without CyclicBarrier");
    try {
      service = Executors.newFixedThreadPool(4);
      WithoutCyclicBarrier manager = new WithoutCyclicBarrier();

      for(int i = 0; i < 4; i++) { 
        service.submit(() -> manager.performTask());
      }
    } finally {
      if(service != null) service.shutdown();
    }

    System.out.println("\nWith CyclicBarrier");
    try {
      service = Executors.newFixedThreadPool(4);
      WithCyclicBarrier manager = new WithCyclicBarrier();
      CyclicBarrier c1 = new CyclicBarrier(4), c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));

      for(int i = 0; i < 4; i++) {
        service.submit(() -> manager.performTask(c1, c2));
      }
    } finally {
      if(service != null) service.shutdown();
    }
  }

}

class WithCyclicBarrier extends LionPenManager {

  public void performTask(CyclicBarrier c1,CyclicBarrier c2) {
    try {
      removeAnimals(); c1.await();
      cleanPen(); c2.await();
      addAnimals();
    } catch (InterruptedException | BrokenBarrierException e) {
      // lalala
    }
  }

}

class WithoutCyclicBarrier extends LionPenManager {
  @Override
  public void performTask() {
    removeAnimals();
    cleanPen();
    addAnimals();
  }
}
