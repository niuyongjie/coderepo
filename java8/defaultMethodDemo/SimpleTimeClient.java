package defaultMethodDemo;

import java.time.*;

import static java.lang.System.out;

/**
 * Created by niuyj on 18-3-5.
 */
public class SimpleTimeClient implements TimeClient {
    private LocalDateTime dateAndTime;

    public SimpleTimeClient() {
        this.dateAndTime = LocalDateTime.now();
    }


    @Override
    public void setTime(int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }

    @Override
    public void setDate(int day, int month, int year) {
        LocalDate currentDate = LocalDate.of(day, month, year);
        LocalTime timeToSet = LocalTime.from(dateAndTime);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        LocalDate currentDate = LocalDate.of(day, month, year);
        LocalTime timeToSet = LocalTime.of(hour, minute, second);
        dateAndTime = LocalDateTime.of(currentDate, timeToSet);
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return dateAndTime;
    }

    @Override
    public ZonedDateTime getZoneDateTime(String zoneString) {
        return null;
    }

    @Override
    public String toString() {
        return "SimpleTimeClient{" +
                "dateAndTime=" + dateAndTime +
                '}';
    }

    public static void main(String[] args) {
        TimeClient timeClient = new SimpleTimeClient();
        out.println(timeClient.getLocalDateTime());
    }
}
