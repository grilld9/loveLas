import grillid9.laslib.BlockParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlockParserTest {

    @Test
    public void testOnCorrectData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("testFile.las"))) {
            BlockParser blockParser = new BlockParser(reader);
            blockParser.parse();
            System.out.println(blockParser.getVersionBlock());
            System.out.println(blockParser.getCurveInfoBlock());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
