public class GenericMethod {

  public static void main(String[] args) {
    System.out.println(Util.<String>compare("a", "b"));
    System.out.println(Util.compare("a", "b"));
    Util obj = new Util();
    obj.<Integer>compare2(5, 6);
    //System.out.println("");
  }

}

class Util {

  public static <T> boolean compare(T a, T b) {
    return a.equals(b);
  }

  public <T> T compare2(int a, T b) {
    // Can't use T within the method
    // T t = new T();
    //System.out.println("compare2: " + t);
    return (T)new Object();
  }

}

class Unbounded<T> {
}
