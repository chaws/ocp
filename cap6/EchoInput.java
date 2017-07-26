import java.io.IOException;
import java.io.Closeable;

class A {}

class Lala extends IOException implements Closeable {
  public void close() {
    throw new RuntimeException();
    //throw new Exception();
    //Lala l = new A(); can't do
  }

  public void lele() {
    try (Lala l = new Lala(); Lala l2 = new Lala();) {
      int a = 2;
    }
    catch(/*Lala |*/ RuntimeException e)
    {}
  }
}

public class EchoInput {
  public static void main(String [] args) {
    if(args.length <= 3) assert false;
    System.out.println(args[0] + args[1] + args[2]);
  }
}
