import grillid9.laslib.VersionParser;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionParserTest {

    @Test
    public void testOnCorrectString() {
        String string =
          "VERS     .                               3.0:CWLS LAS VERSION\n" +
          "WRAP     .                                NO: One line per depth step"
        ;
        Pattern pattern = Pattern.compile("WRAP\\s*.\\s*(YES|NO)");
        Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());
        System.out.println(matcher.group(0));
        System.out.println(("YES").equals(matcher.group(1)));
    }

}
