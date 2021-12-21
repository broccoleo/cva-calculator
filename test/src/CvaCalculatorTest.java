import com.company.CvaCalculator;
import com.company.RiskyBond;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CvaCalculatorTest {

    private final DecimalFormat numberFormat = new DecimalFormat("#.000");

    @Test
    public void testCvaCalculationForRiskyBond() {
        RiskyBond testBond1 = new RiskyBond(5, 100, 0, 0.4, 0.0125, new HashMap<>());
        double bond1Cva = CvaCalculator.calculateCva(testBond1, 0.03);
        assertEquals(String.valueOf(3.155), numberFormat.format(bond1Cva));
    }
}
