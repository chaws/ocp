class A {}
class B extends A {}
class C extends B {}

public class CrazyTemplate <D> /* if it's <A>, java gets confused with A class above */ {
   // Won't work because A is already a class
   // A a1 = new A();
   // Same here 
   // A a2 = new B();
   
   B b1 = new C();
   D d;// = new D();
 

   public D m() {return new D();}

   public static void main(String[] args) {
      CrazyTemplate<String> ct = new CrazyTemplate<>();
   }
}
