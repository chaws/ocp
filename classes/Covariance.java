class Covariance {
  public static void main(String [] args) {
    D d = new D();
    d.m();
  }
}

class A {}
class B extends A {}
class C { A m(){ System.out.println("A::m"); return new A(); } }
class D extends C { B m(){ System.out.println("B::m"); return new B(); } }
/*
  D::m method is still considered an override of C::m because its return type is
  a subclass of C::m return type, THIS IS COVARIANCE 
*/
