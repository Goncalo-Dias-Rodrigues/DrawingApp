import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A custom JPanel that acts as the drawing area,
 * handling the rendering of brush strokes and managing the color and brush size.
*/
public class Canvas extends JPanel {

    private List<BrushStroke> brushStrokes = new ArrayList<>();
    private Color currentColor;
    private int brushSize;
    private MouseAdapter mouseListener;

    /**
     * Sets the drawing color.
     * @param color
     */
    public void setColor(Color color){
        this.currentColor = color;
    }

    /**
     * Sets the brush size.
     * @param brushSize
     */
    public void setBrushSize(int brushSize) {
        this.brushSize = brushSize;
    }

    /**
     * Clears the canvas and removes all strokes.
     */
    public void clearCanvas(){
        brushStrokes.clear();
        repaint();
    }

    /**
     * Removes the last stroke from brushStrokes.
     */
    public void undoLastStroke(){
        if (!brushStrokes.isEmpty()){
            brushStrokes.removeLast();
            repaint();
        }

    }

    /**
     * Custom rendering logic to draw each BrushStroke.
     * @param graphics the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        for(BrushStroke stroke: this.brushStrokes){
            graphics.setColor(stroke.getColor());
            ((Graphics2D) graphics).setStroke(new BasicStroke(stroke.getBrushSize()));
            List<Point> points = stroke.getPoints();
            for (int i = 1; i < points.size(); i++) {
                Point p1 = points.get(i -1);
                Point p2 = points.get(i);
                graphics.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    /**
     * Sets up MouseListener and MouseMotionListener to capture and process drawing actions.
     */
    public void handleMouseEvents(){

        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                BrushStroke stroke = new BrushStroke(currentColor, brushSize);
                stroke.addPoint(e.getPoint());
                brushStrokes.add(stroke);
            }

        };

        MouseMotionListener mouseDragged = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if (!brushStrokes.isEmpty()){
                    BrushStroke currentStroke = brushStrokes.get(brushStrokes.size() - 1);
                    currentStroke.addPoint(e.getPoint());
                    repaint();
                }
            }
        };

        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseDragged);

    }
}
