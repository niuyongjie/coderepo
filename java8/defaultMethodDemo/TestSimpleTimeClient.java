package defaultMethodDemo;

import static java.lang.System.out;

/**
 * Created by niuyj on 18-3-5.
 */
public class TestSimpleTimeClient {
    public static void main(String[] args) {
        TimeClient timeClient = new SimpleTimeClient();
        out.println("Current time : " + timeClient.toString());
        out.println("Time in California " + timeClient.getZoneDateTime("AST").toString());
    }
}
