package grillid9.laslib;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlockParser {

    private String versionBlock = "";
    private String curveInfoBlock = "";
    private final BufferedReader reader;
    public BlockParser(BufferedReader reader) {
        this.reader = reader;
    }

    public void parse() {
        String str;
        char flag = 's';
        Pattern pattern = Pattern.compile("~(\\S)");
        try {
            while ((str = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    if (matcher.group(1).equals("V")) {
                        flag = 'v';
                    } else if (matcher.group(1).equals("C")) {
                        flag = 'c';
                    } else if (matcher.group(1).equals("A")) {
                        break;
                    } else {
                        flag = 's';
                    }
                } else if (flag == 'v') {
                    versionBlock += str + "\n";
                } else if (flag == 'c') {
                    curveInfoBlock += str + "\n";
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String getVersionBlock() {
        if (versionBlock.isEmpty()) {
            throw new NoSuchElementException("There is no version block in the file");
        }
        return versionBlock;
    }

    public String getCurveInfoBlock() {
        if (curveInfoBlock.isEmpty()) {
            throw new NoSuchElementException("There is no curves information block in the file");
        }
        return curveInfoBlock;
    }
}
