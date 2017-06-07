import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nyj on 17-6-6.
 */
public class RegexTest {
    public static void main(String args[]) {
        String str = "https://www.baidu.com";
        String pattern = "(http|https)://[^\\s]*";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());

    }
}
