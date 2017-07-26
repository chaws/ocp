class A{
  class B extends A{}
  class C extends A{}
  class D extends B{}

  public static void main(String args[]) {
      A a = new A();
      a.m();
  }

  public void m() {
    A.B.B b = new A.B.B.B.B.B();
    A.B.C.D abcd = new D.C.B();
  }
}
