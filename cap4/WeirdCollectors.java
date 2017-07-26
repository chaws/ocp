import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.ToDoubleFunction;

public class WeirdCollectors {

  public static void main(String[] args) {
  
    List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9);

    // Averaging
    System.out.println("averagingDouble = " + l.stream().collect(Collectors.averagingDouble(i -> i.intValue() + 1.1)));
    System.out.println("averagingInt = " + l.stream().collect(Collectors.averagingInt(i -> i.intValue() + 1)));
    System.out.println("averagingLong = " + l.stream().collect(Collectors.averagingLong(i -> i.intValue() + 1L)));

    // Counting number of elements
    System.out.println("counting = " + l.stream().collect(Collectors.counting()));
    System.out.println("counting (traditional) = " + l.stream().count());// why did they created this ????

    // toMap
    System.out.println("toMap = " + l.stream().collect(Collectors.toMap(n -> n & 1, n -> n, (n1, n2) -> n1 + n2)));

    // Grouping
    System.out.println("grouping = " + Stream.of("lions", "tigers", "bears").collect(Collectors.groupingBy(String::length)));

    // Partitioning
  }
}
