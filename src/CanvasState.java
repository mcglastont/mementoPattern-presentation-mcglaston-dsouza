import java.util.ArrayList;
import java.util.List;

public class CanvasState implements Cloneable {

    private final List<PenStroke> penstrokes = new ArrayList<>();

    public CanvasState(List<PenStroke> penstrokes) {
        this.penstrokes.addAll(penstrokes);
    }

    public List<PenStroke> getState() {
        return penstrokes;
    }
}
