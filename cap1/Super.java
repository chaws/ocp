/* This is a example to show how the attribute inherited from a super class is not overridden by a especialized class */

public class Super {
  public String name = "Super";

  public void printName() {
    System.out.println(this.name);
  }

  public static void main(String[] args) {
    Super s = new Child();
    Child c = new Child();
    s.printName();
    c.printName();
  }
}

class Child extends Super {
  protected String name = "Child";

  // This breaks the compiler since printName(int) is an overload,
  // and not an override (it's receiving an int as parameter)
  //@Override
  //public void printName(int a) {}
}
