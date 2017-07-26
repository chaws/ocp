import java.util.*;
public class Numbers {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<Integer>();
    numbers.add(1);
    numbers.add(new Integer(3));
    numbers.add(new Integer(5));
    numbers.remove(1);
    numbers.remove(new Integer(5));
    numbers.remove(new Integer(1));
    System.out.println(numbers);
  }

}
