public class Main {
  public static void main(String[] args) {
    System.out.println("begin");

    Runnable r = new PrintData();
    Thread t1 = new ReadInventoryThread();
    Thread t2 = new Thread(r);
    Thread t3 = new ReadInventoryThread();

    t1.start();
    t2.start();
    t3.start();

    System.out.println("end");
  }
}
