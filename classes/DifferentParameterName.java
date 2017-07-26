// Is it OK to override a method changing its parameter name? YES
class Super {
  protected void m(int param) {
    System.out.println("Calling super method");
  }
}

class DifferentParameterName extends Super {
  public void m(int differentName) {
    System.out.println("Calling child method");
  }

  public static void main(String lala[]) {
    DifferentParameterName d = new DifferentParameterName();
    d.m(1);
  }
}
