public class OuterClass {
  public int x = 5;

  protected class Inner {
   
    // The OCP book says inner classes are not allowed
    // to declare static methods or fields
    // that's true unless you make them final
    public static final int x = 10;
    public void go(){ System.out.println(x); }
  }

  public static void main(String[] args) {
    OuterClass o = new OuterClass();
    OuterClass.Inner i = o.new Inner();
    i.go();
  }
}
