package jenkins;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KelvintoCelTest {
    @Test
    public void testKelvintoCel() {
        assertEquals(0, KelvintoCel.kelvintoCel((float) 273.15), 0.1);
    }
}
