import javax.swing.*;
import java.awt.*;

/**
The main class that initializes and displays the application window,
setting up the canvas and toolbar.
*/
public class DrawingApp {

    private static JFrame frame;
    private static Canvas canvas;

    /**
     * Starts the application.
     * @param args
     */
    public static void main(String[] args){
        SwingUtilities.invokeLater(DrawingApp::initialize);
    }

    /**
     * Sets up JFrame, adds the Canvas, and initializes the Toolbar.
     */
    private static void initialize(){
        canvas = new Canvas();
        canvas.setBackground(Color.WHITE);

        Toolbar toolbar = new Toolbar(canvas);

        frame = new JFrame("Drawing App");
        frame.setLayout(new BorderLayout());

        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(canvas, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        canvas.handleMouseEvents();
    }
}
