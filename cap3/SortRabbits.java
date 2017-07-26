import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortRabbits {
  static class Rabbit { int id; public Rabbit(int id){this.id = id;} }
  public static void main(String[] args) {
    List<Rabbit> rabbits = new ArrayList<>();
    rabbits.add(new Rabbit(1));
    Collections.sort(rabbits, (r1, r2) -> r1.id - r2.id);
    System.out.println(rabbits);
  }

}
