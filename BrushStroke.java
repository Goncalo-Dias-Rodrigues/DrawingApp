import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BrushStroke
 * Purpose: Represents a single brush stroke, storing the color,
 * brush size, and points that make up the stroke path.
 */

public class BrushStroke {

    private Color color;
    private int brushSize;
    private List<Point> points = new ArrayList<>();

    /**
     * Constructor to initialize color and brush size.
     * @param color
     * @param brushSize
     */
    public BrushStroke(Color color, int brushSize) {
        this.color = color;
        this.brushSize = brushSize;
    }

    /**
     * Adds a point to the stroke path.
     * @param point
     */
    public void addPoint(Point point){
        points.add(point);
    }

    /**
     * @return color of the stroke
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the brush size.
     */
    public int getBrushSize() {
        return brushSize;
    }

    /**
     * @return the list of points.
     */
    public List<Point> getPoints() {
        return points;
    }
}
