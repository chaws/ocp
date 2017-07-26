import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

class TryWithResources {
  public static void main(String args[]) throws IOException {
    try(InputStream in = new FileInputStream(new File("lala"))) {
      System.out.println("try");
    } catch (Exception e) {
      System.out.println("catch");
    } finally {
      System.out.println("finally");
    }

    try(InputStream in = new FileInputStream(new File("lala"))) {
      System.out.println("try2");
    } catch(FileNotFoundException e) {
      System.out.println("catch2");
    }
    finally {
      System.out.println("finally2");
    }

    try {
      System.out.println("try3");
    } finally {
      System.out.println("finally3");
    }
  }
}
