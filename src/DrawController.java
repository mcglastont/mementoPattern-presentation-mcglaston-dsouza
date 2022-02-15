import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DrawController {

    private final SaveRepo saveStates = new SaveRepo();
    @FXML
    private Canvas canvas;
    private final ArrayList<PenStroke> penStrokes = new ArrayList<>();
    private final int size = 10;
    private Color color;
    @FXML
    public void draw(MouseEvent e) {
        PenStroke square = new PenStroke(new Point2D(e.getX(), e.getY()), color);
        drawSquare(square);
        penStrokes.add(square);
    }

    @FXML
    public void saveCanvas() {
        ArrayList<PenStroke> clonedPenStrokes = new ArrayList<>();
        penStrokes.forEach(p -> clonedPenStrokes.add(new PenStroke(p.getLocation(), p.getColor())));
        saveStates.addState(new CanvasState(clonedPenStrokes));
    }

    @FXML
    public void restoreLastCanvas() {
        try {
            CanvasState state = saveStates.popState();
            clearCanvas();
            loadCanvas(state.getState());
        } catch (NoSuchElementException ignored) {
        }
    }

    private void loadCanvas(List<PenStroke> penStrokes) {
        clearCanvas();
        this.penStrokes.addAll(penStrokes);
        for (PenStroke penStroke: penStrokes) {
            canvas.getGraphicsContext2D().setStroke(penStroke.getColor());
            drawSquare(penStroke);
        }
    }

    @FXML
    private void clearCanvas() {
        penStrokes.clear();
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawSquare(PenStroke square) {
        Point2D location = square.getLocation();
        canvas.getGraphicsContext2D().fillRect(
                location.getX() - (double) size / 2,
                location.getY() - (double) size / 2,
                size,
                size
        );
    }
}
