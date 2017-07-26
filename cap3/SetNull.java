import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SetNull {

  public static void main(String[] args) {
    Set<Integer> s = new HashSet<>();
    s.add(null);
    s.add(1);
    Iterator i = s.iterator();
    while(i.hasNext())
      System.out.println(i.next());

    System.out.print("Printing null = ");
    Object o = null;
    System.out.print(o);
  }

}
