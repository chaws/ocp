import java.util.ArrayList;
import java.util.List;

public class AmbiguousListRemove {

  public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
    ints.add(1);
    ints.add(2);
    ints.add(3);
    ints.add(4);
    ints.add(5);
    // If it's passed as object, will remove the contents
    ints.remove(new Integer(3));
    // If it's passed as int, will remove the equivalent index
    ints.remove(3);
    System.out.println(ints);
  }

}
