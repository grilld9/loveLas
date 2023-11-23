package grillid9.laslib;

import grillid9.laslib.exceptions.LogsReadingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class LogParser {

    private final List<Curve> curves;
    private final BufferedReader reader;
    private final Float nullValue;
    LogParser(BufferedReader reader, List<Curve> curves, Float nullValue) {
        this.reader = reader;
        this.curves = curves;
        this.nullValue = nullValue;
    }
    public void parse() {
        String str;
        int currStringNumber = 0;
        int curvesCount = curves.size();
        try {
            while ((str = reader.readLine()) != null) {
                String[] values = str.split("\\s+");
                if (values.length != curvesCount) {
                    throw new LogsReadingException("Can't resolve curve value at string "
                            + currStringNumber);
                }
                for (int i = 0; i < curvesCount; i++) {
                    float value = Float.parseFloat(values[i]);
                    if (value == nullValue) {
                        curves.get(i).addValue(0F);
                    } else {
                        curves.get(i).addValue(value);
                    }
                }
            }
        } catch (IOException e) {
            throw new LogsReadingException(e.getMessage());
        } catch (NumberFormatException | NullPointerException e) {
            throw new LogsReadingException("Can't parse float curve number");
        }
    }
}
