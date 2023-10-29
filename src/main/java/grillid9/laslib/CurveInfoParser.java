package grillid9.laslib;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurveInfoParser {

    private final String curveInfoBlock;
    private final List<Curve> curves;

    public CurveInfoParser(String curveInfoBlock, List<Curve> curves) {
        this.curveInfoBlock = curveInfoBlock;
        this.curves = curves;
        this.parse();
    }

    private void parse() {
        String[] dataRows = curveInfoBlock.split("\n");
        for (String dataRow : dataRows) {
            Pattern pattern = Pattern.compile("(\\S+)\\s*\\.(\\S+)\\s*:(.*)\\n");
            Matcher matcher = pattern.matcher(dataRow);
            try {
                curves.add(new Curve(matcher.group(1), matcher.group(2),
                        matcher.group(3), new ArrayList<>()));
            } catch (IllegalStateException | IndexOutOfBoundsException e) {
                throw new RuntimeException(); // TODO
            }
        }
    }
}
