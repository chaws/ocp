import java.util.HashMap;
import java.util.Map;

public class HashMapUse {

  public static void main(String[] args) {
    Map<String, String> m = new HashMap<>();
    m.put("key1", "value1");
    m.put("key2", "value2");
    m.put("key3", "value3");
    m.put("key4", "value4");
    m.put("key5", "value5");
    m.put("key6", null);

    for(String s : m.keySet()) {
      System.out.println("m['"+ s +"'] = '"+ m.get(s) + "'");
    }
  }

}
