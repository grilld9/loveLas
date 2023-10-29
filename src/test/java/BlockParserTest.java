import grillid9.laslib.BlockParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlockParserTest {

    @Test
    public void testOnCorrectData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Увязка_651_8707_ВСМР.depth.las"))) {
            BlockParser blockParser = new BlockParser(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
