import java.util.List;
import java.util.ArrayList;

public class OptionalNotTyped
{
  public static void main(String[] args) {
    List<?> l = new ArrayList<>();
    l.add((Object)"lalala");
  }
}
