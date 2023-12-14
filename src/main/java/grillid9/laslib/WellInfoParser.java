package grillid9.laslib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WellInfoParser {

    private final String wellInfoBlock;
    private final WellInfo wellInfo;

    public WellInfoParser(String wellInfoBlock, WellInfo wellInfo) {
        this.wellInfoBlock = wellInfoBlock;
        this.wellInfo = wellInfo;
    }

    public void parse() {
        String[] strings = wellInfoBlock.split("\n");
        for (String string : strings) {
            Pattern pattern = Pattern.compile("^(\\w+)\\s+\\.(\\w*)\\s+(\\w+\\.?\\w*):(.*)");
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                if (matcher.group(1).equals("STRT")) {
                    wellInfo.setStart(Float.parseFloat(matcher.group(3)));
                } else if (matcher.group(1).equals("STOP")){
                    wellInfo.setStop(Float.parseFloat(matcher.group(3)));
                } else if (matcher.group(1).equals("STEP")){
                    wellInfo.setStep(Float.parseFloat(matcher.group(3)));
                }
            }
        }
    }

}
