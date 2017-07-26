import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Duck implements Comparable<Duck> { 
  public String name;

  public int weight;

  public Duck(String name, int weight) {
    this.name = name;
    this.weight = weight;
  } 

  public int compareTo(Duck d) {
    return this.name.compareTo(d.name); // Uses default String.compareTo()
  }
}

public class ComparatorUse {
  
  public static void main(String[] args) {
    Comparator<Duck> byWeight = new Comparator<Duck>() {
      public int  compare(Duck d1, Duck d2) {
        return d1.weight - d2.weight;
      }
    };

    List<Duck> ducks = new ArrayList<>();
    ducks.add(new Duck("Quack1", 12));
    ducks.add(new Duck("Quack2", 11));
    Collections.sort(ducks); // Call Duck.compareTo()
    System.out.println(ducks);
    Collections.sort(ducks, byWeight); // Now call the just created comparator
    System.out.println(ducks);
  }

}
