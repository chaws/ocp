import java.util.function.Predicate;

public class NeatPredicate {

  public static void main(String[] args) {
    Predicate<String> egg = s -> s.contains("egg");
    Predicate<String> brown = s -> s.contains("brown");
    
    // Since egg is a Predicate, we call call 'and()' method to add an AND constraint
    Predicate<String> brownEggs = egg.and(brown);

    // The same thing as above, but now we're also calling "negate()" from brown and adding as AND thru "and()" of egg
    Predicate<String> otherEggs = egg.and(brown.negate());
  }

}
