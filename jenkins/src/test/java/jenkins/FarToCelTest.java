package jenkins;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FarToCelTest {
    @Test   
    public void farToCel(){
        assertEquals(0, FarToCel.farToCel((float) 32), 0.1);
    }
}

