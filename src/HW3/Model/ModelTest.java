package HW3.Model;

import org.junit.*;
import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void testSetValues(){
        Model model = new Model();
        model.setValues("10", "2", "6");
        assertEquals("10", model.getRedValue());
        assertEquals("2", model.getGreenValue());
        assertEquals("6", model.getBlueValue());
    }

}
