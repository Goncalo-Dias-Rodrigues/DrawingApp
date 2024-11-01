import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawingAppTest {

    @Test
    public void testFrame(){
        JFrame jFrame = new JFrame();
        assertNotNull(jFrame);
    }

    @Test
    public void testGetColor(){
        JPanel canvas = new JPanel();
        canvas.setBackground(Color.BLUE);
        assertEquals(Color.blue, canvas.getBackground());
    }
}