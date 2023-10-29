import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurveInfoParserTest {

    @Test
    public void testOnCorrectData() {

        String input = "DEPT     .M                                 :DEPT\n" +
                "SPEE     .M/H                               :Скорость, м/час - 12.326 м.\n";
        String[] dataRows = input.split("\n");
        System.out.println(dataRows[0] + " " + dataRows[1]);
        Pattern pattern222 = Pattern.compile("(\\S+)\\s*\\.(\\S+)\\s*:(.*)\\n");
        Matcher matcher222 = pattern222.matcher(input);
        System.out.println(matcher222.groupCount());
        System.out.println(matcher222.find());
        System.out.println(matcher222.start());
        System.out.println(matcher222.group(3));
    }
}
