import java.util.Optional;

public class ExampleOptional {
  public Optional<Double> avg(int... nums) {
    if(nums.length == 0) return Optional.empty();
    int sum = 0;
    for(int score : nums) sum += score;
    return Optional.of((double) sum / nums.length);
  }
  
  //public <T> void printT(Optional<T> o) {
  //  System.out.println(T.class.getName()); 
  //}

  public static void main(String[] args) {
    ExampleOptional e = new ExampleOptional();
    Optional<Double> op = e.avg(1,2,3,4,5,6,7,8,9);
    op.ifPresent(v -> System.out.println("It's present = " + v));

    Optional<Double> thisisempty = op.filter(v -> {System.out.println("Accessing filter"); return false;});
    double orelse = thisisempty.orElse(42.0);
    System.out.println("This was returned from thisisempty.orElse() = " + orelse);
    double orelseget = thisisempty.orElseGet( () -> {System.out.println("Generating something for orElseGet"); return 42.0;});

    try {
       thisisempty.orElseThrow(() ->  new Exception("hola mondo cruel!"));
    }
    catch(Exception ex) {
      System.out.println("Caught an Exception thrown by thisisempty.orElseThrow() = " + ex.getMessage());
    }

    // The ONLY difference between these two is the return type: one is the Element right away, the other is the Element Wrapped on Optional
    Optional<String> thiswasmappedtostring = op.map(v -> {System.out.println("Mapping to string"); return "lala";});
    Optional<String> earthearlydays = op.flatMap(v -> {System.out.println("Making flat map"); return Optional.of("lala"); });

    System.out.println(e.avg(1,2,3,4,5,6,7,8,9));
    System.out.println(e.avg()); 
    //e.printT(Optional.empty()); 
    //e.printT(Optional.of(4)); 
  }
}
