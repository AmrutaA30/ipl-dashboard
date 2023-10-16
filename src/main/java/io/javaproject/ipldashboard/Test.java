package io.javaproject.ipldashboard;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class Test {
    public static void main(String[] args) {
        String datetimeString = "2023-05-28T14:00:00Z";

        try {
            Instant instant = Instant.parse(datetimeString);
            LocalDate localDate = instant.atZone(ZoneOffset.UTC).toLocalDate();
            System.out.println("Parsed LocalDate: " + localDate);
        } catch (Exception e) {
            System.err.println("Unable to parse the datetime: " + e.getMessage());
        }
    }
}
