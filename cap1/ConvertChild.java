
// This example shows that a runtime exception is thrown
// due to a dynamic cast from B to C at line 20
public class ConvertChild {

  static class A{ 
    //public void say() { System.out.println("A"); } 
  }

  static class B extends A {
    //public void say() { System.out.println("B"); }
  } 

  static class C extends A { 
    //public void say() { System.out.println("C"); } 
  }

  public static void main(String[] args) {
    A b = new B();
    C c = (C)b;
    //c.say();
    System.out.println("lala");
  }
}
