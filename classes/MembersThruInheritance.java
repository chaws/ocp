package classes;
/*
  This file will explor how members are passed to child classes
*/

public class Super {
  // Non-static
  /* default */ int a;
  public int b;
  protected int c;
  private int d;

  // Static
  static int e;
  static public int f;
  static protected int g;
  static private int h;

  class DefaultInner {
    void m() {
      a = 1; // OK 
      b = 1; // OK
      c = 1; // OK
      d = 1; // OK
      e = 1; // OK
      f = 1; // OK
      g = 1; // OK
      h = 1; // OK
    }
  }

  public static void main(){
    Super s = new Super();
  }
}

class OuterNotExtending {
  void m() {
    Super s = new Super();
    s.a = 1; // OK
    s.b = 1; // OK
    s.c = 1; // OK
    //s.d = 1; // NOT OK, private in Super
    s.e = 1; // OK
    s.f = 1; // OK
    s.g = 1; // OK
    //s.h = 1; // NOT OK, private in Super
  }
}
