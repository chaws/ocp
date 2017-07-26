public class LocalInnerClass {
  private int length = 5;
  
  public void calculate() {
    int width = 20;

    class Inner {
      public void multiply() {
        System.out.println(length * width);
      }
    }
   
    // If width id modified again, it won't be considered
    // efectivelly final (it's modified only once) 
    //width = 30;
    
    length = 10;

    Inner i = new Inner();
    i.multiply();
  }

  public static void main(String[] args) {
     LocalInnerClass l = new LocalInnerClass();
     l.calculate();
  }
}
