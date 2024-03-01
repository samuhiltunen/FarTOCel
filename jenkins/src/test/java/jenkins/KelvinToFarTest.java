package jenkins;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KelvinToFarTest {
    @Test
    public void kelvinToFahrenheit() {
        assertEquals(32.0, KelvinToFar.kelvinToFahrenheit(273.15), 0.1);
        assertEquals(212.0, KelvinToFar.kelvinToFahrenheit(373.15), 0.1);
        assertEquals(-459.7, KelvinToFar.kelvinToFahrenheit(0), 0.1);
    }
}