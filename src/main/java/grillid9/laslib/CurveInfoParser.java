package grillid9.laslib;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurveInfoParser {

    private final String curveInfoBlock;
    private final List<Curve> curves;

    CurveInfoParser(String curveInfoBlock, List<Curve> curves) {
        this.curveInfoBlock = curveInfoBlock;
        this.curves = curves;
    }

    public void parse() {
        String[] dataRows = curveInfoBlock.split("\n");
        for (String dataRow : dataRows) {
            Pattern pattern = Pattern.compile("^(\\w+)\\s*\\.(\\S*)\\s*:(.*)");
            Matcher matcher = pattern.matcher(dataRow);
            if (matcher.find()) {
                curves.add(new Curve(matcher.group(1), matcher.group(2),
                    matcher.group(3), new ArrayList<>()));
            }
        }
    }
}
