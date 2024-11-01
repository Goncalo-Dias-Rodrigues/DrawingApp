import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Point;
import java.awt.Color;

public class BrushStrokeTest {
    private BrushStroke stroke;

    @BeforeEach
    public void setUp() {
        stroke = new BrushStroke(Color.BLUE, 10);
    }

    @Test
    public void testAddPoint() {
        stroke.addPoint(new Point(10, 10));
        assertEquals(1, stroke.getPoints().size(), "Deve haver 1 ponto na pincelada.");
    }

    @Test
    public void testGetColor() {
        assertEquals(Color.BLUE, stroke.getColor(), "A cor deve ser azul.");
    }

    @Test
    public void testGetBrushSize() {
        assertEquals(10, stroke.getBrushSize(), "O tamanho do pincel deve ser 10.");
    }

    @Test
    public void testGetPoints() {
        stroke.addPoint(new Point(10, 10));
        stroke.addPoint(new Point(20, 20));
        assertEquals(2, stroke.getPoints().size(), "Deve haver 2 pontos na pincelada.");
    }
}
