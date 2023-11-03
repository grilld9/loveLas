import grillid9.laslib.Curve;
import grillid9.laslib.LasReader;
import java.util.List;
import org.junit.Test;

public class lasParserTest {

    @Test
    public void correctFileTest() {
        LasReader lasReader = new LasReader("testFile.las");
        lasReader.read();
        System.out.println(lasReader.getVersion());
        System.out.println(lasReader.isWrap());
        int curvesCount = lasReader.getCurves().size();
        for (int i = 0; i < curvesCount; i++) {
            Curve curve = lasReader.getCurves().get(i);
            System.out.println(curve.getName());
            List<Float> curveValues = curve.getData();
            for (Float value : curveValues) {
                System.out.println(value);
            }
        }
    }
}
