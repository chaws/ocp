class Primate {
  public boolean hasHair() {
    return true;
  }
}

interface HasTail {
  public boolean isTailStriped();
}

public class Lemur extends Primate implements HasTail {
  public int age = 10;

  public boolean isTailStriped() {
    return false;
  }

  public static void main(String[] args) {
    //int inteiro = 10;
    //if(inteiro.toString())
    //  System.out.println("Acceptiing strings in ifs");
    //else
    //  System.out.println("Naaah, just mocking");
      
    Lemur lemur = new Lemur();
    System.out.println(lemur.age);

    HasTail hasTail = lemur;
    System.out.println(hasTail.isTailStriped());

    Primate primate = lemur;
    System.out.println(primate.hasHair());
    System.out.println(primate.age); // Does not compile cuz primate is ageless

    // Lemur lemur2 = primate; // Does not compile
    Lemur lemur2 = (Lemur)primate; // Does compile
    System.out.println(lemur2.age);
  }
} 
    
