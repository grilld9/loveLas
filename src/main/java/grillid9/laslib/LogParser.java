package grillid9.laslib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogParser {

    public void parse() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("Увязка_651_8707_ВСМР.depth.las"))) {
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }
}
