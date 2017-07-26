import static java.lang.System.out;

public class ReferenceAndObjectType {
  public static void main(String args[]) {
    A aa = new A(); // OK
    A ab = new B(); // OK
    // B ba = new A(); // NOT OK, A does not have all members required by B
    B bb = new B(); // thankfully, OK
    // Let's play a game
    out.print("aa.m(): "); aa.m();
    out.print("ab.m(): "); ab.m();
    out.print("bb.m(): "); bb.m();

    // Let's cast it away!
    // out.print("((B)aa).m(): "); ((B)aa).m(); // NOT OK, A can't be cast to B
    out.print("((B)ab).m(): "); ((B)ab).m();
    out.print("((A)bb).m(): "); ((A)bb).m();
  }
}

class A {
  int a = 1;
  int b = 2;
  void m() {
    out.println("A::m");
    out.println("A::a = " + a); // a = 1
    out.println("A::b = " + b); // b = 2
  }
}

class B extends A {
  int b = 3;
  int d = 4;
  void m() {
    out.println("B::m");
    out.println("B::a = " + a); // a = 1
    out.println("B::b = " + b); // b = 3
    out.println("B::d = " + d); // d = 4
  }
}
