import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurveInfoParserTest {

    @Test
    public void testOnCorrectData() {

        String input = "DEPT     .M                                 :DEPT\n" +
                "SPEE     .M/H                               :Скорость, м/час - 12.326 м.\n";
        String[] dataRows = input.split("\n");
        Pattern pattern222 = Pattern.compile("(\\S+)\\s*\\.(\\S+)\\s*:(.*)");
        Matcher matcher222 = pattern222.matcher(dataRows[0]);
        System.out.println(matcher222.groupCount());
        System.out.println(matcher222.find());
        System.out.println(matcher222.group(3));

    }
}
