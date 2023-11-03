package grillid9.laslib;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionParser {

    private final String versionBlock;
    private String version;
    private boolean wrap;

    public VersionParser(String versionBlock) {
        this.versionBlock = versionBlock;

    }

    /**
     * Parse .las file version from ~VER topic
     * @throws NoSuchElementException - If there is no version information in the file
     */

    public void parse() {
        parseVersion();
        parseWrap();
    }

    private void parseVersion() throws NoSuchElementException {
        Pattern pattern = Pattern.compile("VERS\\s*\\.\\s*(\\d*\\.\\d*)");
        Matcher matcher = pattern.matcher(versionBlock);
        if (matcher.find() && matcher.groupCount() > 0) {
            version = matcher.group(1);
        } else {
            throw new NoSuchElementException("Cannot find version information");
        }

    }

    /**
     * Parse .las file wrap information from ~VER topic
     * @throws NoSuchElementException - If there is no wrap information in the file
     */
    private void parseWrap() throws NoSuchElementException {
        Pattern pattern = Pattern.compile("WRAP\\s*.\\s*(YES|NO)");
        Matcher matcher = pattern.matcher(versionBlock);
        if (matcher.find() && matcher.groupCount() > 0) {
            wrap = ("YES").equals(matcher.group(1));
        } else {
            throw new NoSuchElementException("Cannot find wrap information");
        }
    }

    public String getVersion() {
        return version;
    }

    public boolean isWrap() {
        return wrap;
    }



}
