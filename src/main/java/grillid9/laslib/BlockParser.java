package grillid9.laslib;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlockParser {

    String versionBlock = "";
    String curveInfoBlock = "";
    private final BufferedReader reader;
    public BlockParser(BufferedReader reader) {
        this.reader = reader;
        this.parse();
    }

//    public void parse() {
//        try {
//            String str = reader.readLine();
//            while (reader.ready()) {
//                if (str.charAt(0) == '~') {
//                    if (str.charAt(1) == 'V') { // VERSION
//                        str = reader.readLine();
//                        do {
//                            versionBlock += str + "\n";
//                            str = reader.readLine();
//                        } while (str.charAt(0) != '~');
//                    } else if (str.charAt(1) == 'C') {
//                        str = reader.readLine();
//                        do {
//                            curveInfoBlock += str + "\n";
//                            str = reader.readLine();
//                        } while (str.charAt(0) != '~');
//                    } else if (str.charAt(1) == 'A') {
//                        break;
//                    } else {
//                        str = reader.readLine();
//                    }
//                } else {
//                    str = reader.readLine();
//                }
//            }
//        } catch (IOException | IndexOutOfBoundsException e) {
//            throw new RuntimeException("File is incorrect");
//        }
//    }

    public void parse() {
        String str;
        Pattern pattern = Pattern.compile("~(\\S)");
        try {
            while ((str = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    if (matcher.group(1).equals("V")) {
                        
                    }
                }





            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
}
