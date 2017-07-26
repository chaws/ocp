import java.util.List;
import java.util.ArrayList;

public class LegacyArrayList {

  public static void main(String[] args) {
    List l = new ArrayList();
    l.add("one");
    l.add("two");
    l.add(7);
    for (String s : l)
      System.out.println(s);
  }

}
