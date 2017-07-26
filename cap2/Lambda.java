class Animal {
  private boolean canHop;
  public Animal(boolean hopper) {
    this.canHop = hopper;
  }
  
  public boolean canHop() { return this.canHop; }
}

class FindingMatchingAnimals {
  public void print(Animal animal, CheckTrait trait) {
    if(trait.test(animal))
      System.out.println(animal);
  }
}

public class Lambda {
  public static void main(String[] args) {
    FindingMatchingAnimals f = new FindingMatchingAnimals();
    f.print(new Animal(false), a->a.canHop());
    f.print(new Animal(true), a -> a.canHop());
  }  
}
