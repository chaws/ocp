import java.time.ZoneId;

public class AllTimeZones {
  public static void main(String[] args) {
    ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
  }
}
