public class ReadInventoryThread extends Thread {
  public void run() {
    System.out.println("Printing zoo inventory");
  }

  public static void main(String[] args) {
    Thread t = new ReadInventoryThread();
    t.start();
  }
}
