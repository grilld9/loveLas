package grillid9.laslib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LasReader {

    public List<Curve> getCurves() {
        return curves;
    }

    public String getVersion() {
        return version;
    }

    public boolean isWrap() {
        return isWrap;
    }

    private final String lasFile;
    private final List<Curve> curves = new ArrayList<>();
    private String version;
    private boolean isWrap;
    public LasReader(String lasFile) {
        this.lasFile = lasFile;
    }

    public void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(lasFile))) {
            BlockParser blockParser = new BlockParser(reader);
            blockParser.parse();
            Float nullValue = blockParser.getNullValue();
            VersionParser versionParser = new VersionParser(blockParser.getVersionBlock());
            versionParser.parse();
            CurveInfoParser curveInfoParser = new CurveInfoParser(blockParser.getCurveInfoBlock(),
                curves);
            curveInfoParser.parse();
            version = versionParser.getVersion();
            isWrap = versionParser.isWrap();
            LogParser logParser = new LogParser(reader, curves, nullValue);
            logParser.parse();
        } catch (IOException e) {
            throw  new RuntimeException("Cant't open file");
        }
    }
}
