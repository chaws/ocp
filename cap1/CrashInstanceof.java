public class CrashInstanceof {
  public static void main(String[] args) {
    Super s = new Super();
    
    // This breaks because the compiler knows for sure that
    // s can't be from the same class tree as Child
    // boolean b = s instanceof Child;

    // Test if the program compiles if null tested with instance
    boolean c = null instanceof Super || Boolean.FALSE; 
   
    System.out.println("Incredible like the live above passes");
  }
}

class Super {}

class Child {}

class Another {}
