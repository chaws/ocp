import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamSample {

  public List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
    List<Animal> animals = new ArrayList<>();
    try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
      while(true) {
        Object obj = in.readObject();
        if(obj instanceof Animal) {
          animals.add((Animal)obj);
        }
      }
    } catch (EOFException e) {
    
    }

    return animals;
  }

  public void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
      for(Animal a : animals) {
        out.writeObject(a);
      }
    } 
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException{
    File dataFile = new File("animals.data");
    ObjectStreamSample oss = new ObjectStreamSample();
    List<Animal> animals = Arrays.asList(new Animal("rat", 10, 'c'), new Animal("gat", 42, 'g'));
    oss.createAnimalsFile(animals, dataFile);

    animals = oss.getAnimals(dataFile);
    System.out.println(animals);
  }

}
