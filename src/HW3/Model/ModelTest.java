package HW3.Model;

import org.junit.*;
import static org.junit.Assert.*;

public class ModelTest {
    @Test
    public void testReset(){
        Model model = new Model();
        model.addClass("Reset");
    }

}
