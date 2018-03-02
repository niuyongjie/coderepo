import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        jdk_7_SimpleDateFormatter();
        jdk_8_DateTimeFormatter();
    }

    private static void jdk_8_DateTimeFormatter() {
        // JDK 8 使用 DateTimeFormatter 对 Date 数据进行格式化
        Date date = new Date(117, 10, 10);
        long t2 = System.currentTimeMillis();
        Instant instant = date.toInstant();
        String dateFormatter = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(dateFormatter);
        System.out.println("DateTimeFormatter coast time: " + (System.currentTimeMillis() - t2));
    }

    private static void jdk_7_SimpleDateFormatter() {
        // JDK 7 使用 SimpleDateFormatter 对 Date 数据进行格式化
        Date date = new Date(117, 10, 10);
        long t1 = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(date));
        System.out.println("SimpleDateFormatter coast time: " + (System.currentTimeMillis() - t1));
    }
}
