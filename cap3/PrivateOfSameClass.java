public class PrivateOfSameClass {

  private int f;
  public void m(PrivateOfSameClass p) {
    p.f = 0;
  }

  public static void main(String[] args)
  {
    PrivateOfSameClass p = new PrivateOfSameClass();
    PrivateOfSameClass p2 = new PrivateOfSameClass();
    p.m(p2);
  }

}
