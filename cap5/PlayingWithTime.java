import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.temporal.IsoFields;

public class PlayingWithTime {

  public static void main(String[] args) {

    // Using datetime in java8, which is much better!
    // Now we have one class for each case: one for dates only (LocalDate), hours only (LocalTime), dates and hours together (LocalDateTime) aaaaaaaaaa
    // aaaaaand a dates and hours WITH timezone (ZonedDateTime) 

    // LocalDate
    // In september of 1752 the calendar jumped from 2 to 13, i forgot the reason why, but it's true (check with `cal 1752`)
    System.out.println("Playing around with LocalDate");
    System.out.println("Numer of days from 1970 (epoch) till LocalDate.now() = " + LocalDate.now().toEpochDay());
    System.out.println("LocalDate.of(2016, 1, 1) = " + LocalDate.of(2016, 1, 1));
    System.out.println("LocalDate.of(2016, Month.JANUARY, 1) = " + LocalDate.of(2016, Month.JANUARY, 1));
    System.out.println("LocalDate.ofYearDay(2017, 60) = " + LocalDate.ofYearDay(2017, 60) + ", ooopsie, 2016 is not leap year, java got us wrong");
    //System.out.println("Period from 01-01-2016 until 02-29-2016 = " + LocalTime.of(1, 1, 2016).until(LocalTime.of(2, 29, 2016), null));
    LocalDate ld = LocalDate.of(1752, Month.SEPTEMBER, 2);
    ld = ld.plusDays(-1);
    System.out.println("ld = " + ld);

    // LocalTime
    System.out.println("\nPlaying around with LocalTime");
    System.out.println("Numer of seconds from 1970 (epoch) till LocalDateTime.now() = " + LocalDateTime.now().toEpochSecond());
    System.out.println("LocalTime.of(1, 1) = " + LocalTime.of(1, 1)); // hour and minute
    System.out.println("LocalTime.of(1, 1, 1) = " + LocalTime.of(1, 1, 1)); // hour, minute and second
    System.out.println("LocalTime.of(1, 1, 1, 1) = " + LocalTime.of(1, 1, 1, 1)); // hour, minute, second and nano of second
    System.out.println("LocalTime.ofSecondOfDay(1356) = " + LocalTime.ofSecondOfDay(1356)); // get the time from the beginning of the day until the number of seconds ellapsed
    System.out.println("LocalTime.ofNanoOfDay(1356938455) = " + LocalTime.ofNanoOfDay(1356938455)); // get the time from the beginning of the day until the number of nanoseconds ellapsed
    System.out.println("LocalTime.parse(\"12:34\") = " + LocalTime.parse("12:34")); // Getting a localtime from a string
    System.out.println("Period from 00:01:02.3456 until 23:59:59.0101 = " + LocalTime.of(0, 1, 2, 3456).until(LocalTime.of(23, 59, 59, 0101), ChronoUnit.SECONDS));
    LocalTime now = LocalTime.now();
    System.out.println("LocalTime.now() = " + now);
    System.out.println("Plus/Minus operations");
    System.out.println("LocalTime.now().plusHours(1) = " + now.plusHours(1));
    System.out.println("LocalTime.now().plusHours(1).plusMinutes(10) = " + now.plusHours(1).plusMinutes(10));
    System.out.println("LocalTime.now().plusHours(1).plusMinutes(10).plusSeconds(5) = " + now.plusHours(1).plusMinutes(10).plusSeconds(5));
    System.out.println("LocalTime.now().plusHours(1).plusMinutes(10).plusSeconds(5).plusNanos(100) = " + now.plusHours(1).plusMinutes(10).plusSeconds(5).plusNanos(100));
    System.out.println("LocalTime.now().plus(Duration.of(1, HOURS)) = " + now.plus(Duration.of(1, ChronoUnit.HOURS)));
    System.out.println("LocalTime.now().plus(Duration.of(1, MINUTES)) = " + now.plus(Duration.of(1, ChronoUnit.MINUTES)));
    System.out.println("LocalTime.now().plus(Duration.of(1, SECONDS)) = " + now.plus(Duration.of(1, ChronoUnit.SECONDS)));
    System.out.println("LocalTime.now().plus(Duration.of(1, MILLIS)) = " + now.plus(Duration.of(1, ChronoUnit.MILLIS)));
    System.out.println("LocalTime.now().plus(Duration.of(1, MICROS)) = " + now.plus(Duration.of(1, ChronoUnit.MICROS)));
    System.out.println("LocalTime.now().plus(Duration.of(1, NANOS)) = " + now.plus(Duration.of(1, ChronoUnit.NANOS)));
    System.out.println("LocalTime.now().plus(Duration.of(1, HALF_DAYS)) = " + now.plus(Duration.of(1, ChronoUnit.HALF_DAYS)));
    System.out.println("Merging to create other objects");
    System.out.println("LocalTime.now().atDate(LocalDate.now()) = " + now.atDate(LocalDate.now()));

    // LocalDateTime
    System.out.println("\nPlaying around with LocalDateTime");     
    System.out.println("LocalDateTime.now() = " + LocalDateTime.now());     
    System.out.println("LocalDateTime from Time and Date " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));     

    // ZonedDateTime
    System.out.println("\nPlaying around with ZonedlDateTime");     
    System.out.println("ZonedDateTime.now() = " + ZonedDateTime.now());
    System.out.println("ZonedDateTime.of(2016, 1, 1, 13, 30, 10, 100) = " + ZonedDateTime.of(2016, 1, 1, 13, 30, 10, 100, ZoneId.of("America/New_York")));

    // Using Periods
    System.out.println("\nPlaying around with Periods");     
    System.out.println("Period.of(1, 2, 3) = " + Period.of(1, 2, 3));
    System.out.println("Period.of(-1, -2, -3) = " + Period.of(-1, -2, -3));
    System.out.println("Period.ofMonths(1) = " + Period.ofMonths(1));
    System.out.println("Period.of(1, 0, 40) = " + Period.of(1, 0,  40));
  }

}
