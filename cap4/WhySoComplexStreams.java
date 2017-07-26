import java.util.function.Consumer;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.OptionalInt;
import java.lang.StringBuilder;

public class WhySoComplexStreams {
  public static void main(String[] args) {
    Consumer<String> console = System.out::println;
    BinaryOperator<Double> acumulator = (d1, d2) -> d1 + d2;
    Double beginning = 0.0;

    // ******************************* Intermediate methods

    // ******************************* Terminal methods
    // Reduce 1
    Stream<Double> s1 = Stream.of(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0);
    System.out.println("Reduce 1: " + s1.reduce(beginning, acumulator)); 
    // And Is equivalent to
    // T result = identity;
    // for (T element : this stream)
    //    result = accumulator.apply(result, element) // Transform it into an array (which is funny)
  
    // Reduce 2, returns an optional,instead of a flat element 
    Stream<Double> s2 = Stream.of(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0);
    System.out.println("Reduce 2: " + s2.reduce(acumulator)); 
    //boolean foundAny = false;
    //T result = null;
    //for (T element : this stream) {
    //    if (!foundAny) {
    //        foundAny = true;
    //        result = element;
    //    }
    //    else
    //        result = accumulator.apply(result, element);
    //}
    //return foundAny ? Optional.of(result) : Optional.empty();

    // Collect 1: basically same as reduce, but using identity as the unique object to hold thru all iterations
    Stream<String> s3 = Stream.of("l", "a", "l", "a");
    System.out.println("Collect = " + s3.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append));
    
    // R result = supplier.get();
    // for (T element : this stream)
    //    accumulator.accept(result, element);

    // Object[] arr = s.toArray(); // needless to say, this finishes the stream
    // String[] arr = s.toArray(d -> "" + d); // needless to say, this finishes the stream
    // console.accept("Array = " + arr);

    // Find any element in the stream
    // console.accept("findAny() = " + s.findAny()); // Kills the stream
    // console.accept("findfirst() = " + s.findFirst()); // Kills the stream

    // Check if all elements match a condition
    // console.accept("allMatch() = " + s.allMatch(v -> v < 100)); This kills the stream
    // console.accept("anyMatch() = " + s.anyMatch(v -> v < 100)); This kills the stream
    // console.accept("noneMatch() = " + s.noneMatch(v -> v < 100)); This kills the stream

    // s.count() kills the stream
    //System.out.println("s.count() = " + s.count());

    //  This actually forces to be IntStream, instead of Stream<Integer>, impressive!
    Stream<Double> s4 = Stream.of(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0);
    IntStream i = s4.mapToInt(v -> {System.out.println("Parsing = " + v); return v.intValue();});

    // Filtering (still referencing the same stream s)
    IntStream odds = i.filter(v -> {System.out.println("Filtering " + v); return (v & 1) == 0;});

    // Can't call odds.count() cuz the main stream was already killed by 's.count()'
    // System.out.println("odds.count() = " + odds.count());

    // forEach actually kills the stream
    //odds.forEach(v -> System.out.println("Going through odds = " + v));
    // let's try doing it with peek
    //odds.peek(v -> System.out.println("Peeking through odds = " + v));

    OptionalInt min = odds.min();/*, max = i.max(); Can't do, min/max are terminal operations */
    min.ifPresent(m -> System.out.println("Min optional value = " + m));
    //max.ifPresent(m -> System.out.println("Max optional value = " + m));

    // Creating an infinite stream
    Stream<Double> inf = Stream.generate(Math::random); // same as Stream.iterate(1, n -> n + 1);
    // line below goes infinitly
    // inf.forEach(v -> System.out.println("Going through infinite = " + v));

    System.out.println("Too tired right now, Let's get some icecream =)");
  }
}
