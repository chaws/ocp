import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.BiConsumer;

// Function, To{Double|Int|Long}Function, {Double|Int|Long}Function
// One T parameter and R return
import java.util.function.Function;

// One {double|int|long} parameter and one R return, respectivelly
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

// One T parameter and one {double|int|long} return
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

// IntTo{Double|Long}Function, DoubleTo{Int|Long}Function, LongTo{Double|Int}Function
// One {int|double|long} parameter and one return {{double|long}|{int|long}|{double|int}}, respectivelly
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;

// BiFunction, To{Double|Int|Long}BiFunction
import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

// All these Function imports were typed in order to get some practice

import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

import java.util.function.Supplier;
import java.util.function.DoubleSupplier;

import java.util.Objects;

class Suppliers {
  // Most basic supplier
  public static int a_naive_supplier() {return 42;}

  public static void show() {
    Supplier<Integer> s1 = Suppliers::a_naive_supplier;
    s1.get();

    Supplier<Integer> s2 = () -> "lala".length();
    s2.get();

    DoubleSupplier s3 = () -> (double)5; // Same for Int, Long and Boolean
    s3.getAsDouble();
  }
}

// World population a-ha
class Consumers {
  // Most basic consumer
  public static int a_naive_consumer(int a){ System.out.println("Consuming " + a); return 42;}

  // Let's try to make java dizzy
  public static void dummymeth(int arg1, int arg2){ System.out.println("Calling Consumers::dummymeth with two args"); }
  public static void dummymeth(int arg1){ System.out.println("Calling Consumers::dummymeth with one arg"); }

  public static void show() {
    Consumer<Integer> c1 = Consumers::a_naive_consumer;
    c1.andThen(System.out::println)
      .andThen(i -> System.out.println("Recursively consumig " + i))
      .accept(42);
    
    DoubleConsumer c2 = (d) -> System.out.println("This is a DoubleConsumer " + d); // Same for Int and Long 
    c2.accept(4.2);

    class MyObj { public String toString(){ return "Hi from MyObj ";}}

    // Same for ObjDoubleConsumer, and ObjLongConsumer, both receiving T and double|long
    ObjIntConsumer<MyObj> c3 = (obj, inT) -> System.out.println("This is kinda of BiConsumer, but with a T object and an Int " + obj + inT);
    c3.accept(new MyObj(), 42);

    // Using extreme generics <?,?> does not work!!! 
    // BiConsumer<?,?> c4 = (MyObj o, String s) -> System.out.println("This is a BiConsumer receiving the type at assigment " + o + s);
    BiConsumer<MyObj, String> c4 = (MyObj o, String s) -> System.out.println("This is a BiConsumer receiving the type at assigment " + o + s);
    c4.accept(new MyObj(), "crazy str"); 

    // Forcing use of overload 
    //BiConsumer<Consumers, Integer> c5 = Consumers::dummymeth;
    // c5.accept(new Consumers(), 42);
    // BiConsumer<Integer, Integer> c6 = Consumers::dummymeth;
    // c6.accept(42, 42);
  }
}

class Predicates {
  public void show() {
    Predicate<Object> p1 = (o) -> {System.out.println("This is a simple predicate " + o); return 1 == 1;};
    p1.test(42);

    BiPredicate<Object, Object> p2 = Objects::equals;
    p2.test(42, 42); 

    try {
      IntPredicate p3 = (IntPredicate)(((Predicate<Integer>)((myint) -> {System.out.println("Crazy IntPredicate"); return myint == 42;})).and((i) -> false));
      p3.test(42);
    }
    catch(ClassCastException e)
    {
      System.out.println("Ooops, Crazy predicate casting didn't work, perhaps java doesn't allow such creativity =P ");
    }
  }
}

class Functions {
  public void show() {
    // Single-parameter functions
    Function<String, Integer> f1 = String::length;	f1.apply("hello s functions");
    DoubleFunction<String> f2 = (d) -> "" + d; 		f2.apply(42.0);
    IntFunction<String> f3 = (i) -> "" + i;		f3.apply(42);
    LongFunction<String> f4 = (l) -> "" + l;		f4.apply(42L);
    
    // Casting primitive datatype functions
    DoubleToIntFunction f5 = (d) -> 42;			f5.applyAsInt(42.0);
    DoubleToLongFunction f6 = (d) -> 42L;		f6.applyAsLong(42.0);
    IntToDoubleFunction f7 = (i) -> 42.0;		f7.applyAsDouble(42);
    IntToLongFunction f8 = (i) -> 42L;			f8.applyAsLong(42);
    LongToDoubleFunction f9 = (l) -> 42.0;		f9.applyAsDouble(42L);
    LongToIntFunction f10 = (l) -> 42;			f10.applyAsInt(42L);
   
    // Casting Objects into primitive datatypes
    ToDoubleFunction<String> f11 = (s) -> 42.0; 	f11.applyAsDouble("str");
    ToIntFunction<String> f12 = (s) -> s.length();	f12.applyAsInt("str");
    ToLongFunction<String> f13 = (s) -> 42L;		f13.applyAsLong("str");

    // Two-parameter function
    BiFunction<String, String, String> f14 = (s1, s2) -> s1 + s2;	f14.apply("str1", "str2");
    ToDoubleBiFunction<String, String> f15 = (s1, s2) -> 42.0;		f15.applyAsDouble("str1", "str2");
    ToIntBiFunction<String, String> f16 = (s1, s2) -> 42;		f16.applyAsInt("str1", "str2");
    ToLongBiFunction<String, String> f17 = (s1, s2) -> 42L;		f17.applyAsLong("str1", "str2");
  }
}

public class TypesOfBuiltinFunctionalInterfaces {
  public static void main(String[] args) {
    System.out.println("Suppliers");
    Suppliers s = new Suppliers();
    s.show();

    System.out.println("Consumers");
    Consumers c = new Consumers();
    c.show();

    Predicates p = new Predicates();
    p.show();
  }
}
