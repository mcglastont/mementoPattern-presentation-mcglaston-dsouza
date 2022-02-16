import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class CanvasState implements Cloneable {

    private final List<PenStroke> penstrokes = new ArrayList<>();
    private final Color color;

    public CanvasState(List<PenStroke> penstrokes, Color currentColor) {
        this.penstrokes.addAll(penstrokes);
        this.color = currentColor;
    }

    public List<PenStroke> getState() {
        return penstrokes;
    }

    public Color getColor() {
        return color;
    }
}
