import org.junit.Test;

public class LogParserTest {

    @Test
    public void testOnCorrectData() {
        String input = "~A           SPEE       IPRS        RGR         GR     GR_AVG         RNTN       RFTN       NTNL       FTNL       TRNP          RSDL         RLDL       RHOB  RHOB_POST       RAD1    RAD2    RAD3       CALI        PHL        ROPL        PHH       ROPH       PHLD      ROPLD       PHHD       ROPHD       PHLE      ROPLE       PHHE       ROPHE         AL         AH        ALD        AHD        ALE        AHE  RGR_VIKPB   GR_VIKPB _AVG_VIKPB       OPRS\n" +
                       "3144.2  180.00000   36.45000 1650.00000    6.70000    7.10000  50040.00000  420.00000    1.33200    1.89700   53.90000  628620.00000  71280.00000    2.56000    2.56789   82.00000    0.00    0.00  155.40000   -0.01000  -999.25000   -0.01000 -999.25000   -0.01000 -999.25000   -0.01000  -999.25000   -0.01000 -999.25000   -0.01000  -999.25000    1.00000    1.00000    1.00000    1.00000    1.00000    1.00000  420.00000    2.60000    2.55000   31.89000\n";

        String[] names = input.split("\\s+");
        for (String name : names) {
            System.out.println(name);
        }

    }
}
