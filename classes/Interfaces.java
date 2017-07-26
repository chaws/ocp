interface I {
  // private int a = 1; // NOT OK, members MUST be public
  // protected int a = 1; // NOT OK, same as above
  public int a = 1; // OK, it's redundant, but OK
  int b = 2; // it's NOT default, it's PUBLIC
  public static int c = 1; // OK
  static int d = 1; // OK
  // static public e = 1; // NOT OK, access modifier MUST come before specifier

  void m1(); // OK, it's an abstract PUBLIC declaration
  // void m2() {} // NOT OK, because it is NOT static
  static void m3() {} // OK, since it's static
  // protected void m4(); // NOT OK, protected not allowed
}

class Impl implements I {
  public void m1() {} 
  public void m3() {}
}

class Interfaces {
  public static void main(String lala[]) {
    Impl i = new Impl();
  }
}
