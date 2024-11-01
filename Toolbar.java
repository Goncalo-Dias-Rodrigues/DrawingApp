import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Toolbar
 * Purpose: Manages the controls (color selection, brush size, clear, and undo) that interact with the Canvas.
 */
public class Toolbar extends JPanel {

    private Canvas canvas;
    private List<Color> colors;
    private List<JButton> colorButtons;
    private JSlider brushSlider;
    private JButton clearButton;
    private JButton undoButton;

    /**
     * Constructor that links the toolbar to the canvas and initializes UI components.
     * @param canvas
     */
    public Toolbar(Canvas canvas){
        this.canvas = canvas;
        initializeColors();
        initializeComponents();
        setUpBrushSlider();
        setUpColorSelection();
        setUpClearButton();
        setUpUndoButton();
    }

    private void initializeColors() {
        this.colors = new ArrayList<>();
        this.colors.add(Color.RED);
        this.colors.add(Color.GREEN);
        this.colors.add(Color.BLUE);
    }

    private void initializeComponents() {
        this.colorButtons = new ArrayList<>();
        this.brushSlider = new JSlider(0,100,50);
        this.clearButton = new JButton("Clear");
        this.undoButton = new JButton("Undo");

        setLayout(new FlowLayout());
        add(this.brushSlider);
        add(this.clearButton);
        add(this.undoButton);

    }

    /**
     * Sets up color selection buttons and links them to Canvas.
     */
    public void setUpColorSelection(){
        for(Color color: this.colors){
            JButton button = new JButton();
            button.setBackground(color);
            button.setPreferredSize(new Dimension(30,30));
            button.addActionListener(e -> canvas.setColor(color));
            colorButtons.add(button);
            add(button);
        }
    }

    /**
     * Sets up a slider to change brush size and updates Canvas accordingly.
     */
    public void setUpBrushSlider() {
        this.brushSlider.addChangeListener(e -> {
            int size = this.brushSlider.getValue();
            canvas.setBrushSize(size);
        });
    }

    /**
     * Sets up the clear button to clear the canvas.
     */
    public void setUpClearButton(){
        this.clearButton.addActionListener(e -> canvas.clearCanvas());
    }

    /**
     * Sets up the undo button to remove the last stroke.
     */
    public void setUpUndoButton(){
        this.undoButton.addActionListener(e -> canvas.undoLastStroke());
    }
}
