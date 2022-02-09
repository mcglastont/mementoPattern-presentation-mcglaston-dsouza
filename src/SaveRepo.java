
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SaveRepo{

    List<CanvasState> states = new ArrayList<CanvasState>();

    public void addState(CanvasState c) {
        states.add(c);
    }

    public CanvasState popState() {
        if (states.size() == 0) throw new NoSuchElementException();
        CanvasState state = states.get(states.size() - 1);
        states.remove(states.size() - 1);
        return state;
    }

}
