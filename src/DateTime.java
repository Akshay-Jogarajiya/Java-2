import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static void main(String[] args) {

        //Local Date
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2004, 12, 16);

        System.out.println(today);
        System.out.println(birthday);

        //Local Time
        LocalTime now1 = LocalTime.now();
        LocalTime time = LocalTime.of(23, 59, 59);
        System.out.println(time);
        System.out.println(now1);

        //Local Data Time
        LocalDateTime now2 = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(today, time);
        System.out.println(dateTime);
        System.out.println(now2);

        //Date and Time with TimeZone
        ZonedDateTime europeTime = ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(europeTime);
        System.out.println(indiaTime);

        //Format
        LocalDateTime now = LocalDateTime.now();

        // 1. Define the format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // 2. Format: LocalDateTime → String
        String formatted = now.format(formatter);
        System.out.println("Formatted: " + formatted);

        // 3. Parse: String → LocalDateTime
        String dateStr = "25-12-2024 10:30";
        LocalDateTime parsed = LocalDateTime.parse(dateStr, formatter);
        System.out.println("Parsed: " + parsed);
    }
}
