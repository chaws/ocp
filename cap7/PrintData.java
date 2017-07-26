public class PrintData implements Runnable {
  public void run() {
    for(int i = 0; i < 3; i++) {
      System.out.println("Printing record: :" + i);
    }
  }

  public static void main(String[] args) {
    Runnable r = new PrintData();
    Thread t = new Thread(r);
    t.start();
  }
}

