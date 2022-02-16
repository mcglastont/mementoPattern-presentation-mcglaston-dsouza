import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DrawController {

    private final SaveRepo saveStates = new SaveRepo();
    @FXML
    private Canvas canvas;
    private final ArrayList<PenStroke> penStrokes = new ArrayList<>();
    private final int size = 10;
    private Color currentColor = Color.BLACK;

    @FXML
    public void draw(MouseEvent e) {
        PenStroke square = new PenStroke(new Point2D(e.getX(), e.getY()),
                new Color(currentColor.getRed(), currentColor.getGreen(),
                        currentColor.getBlue(), currentColor.getOpacity()));
        drawSquare(square);
        penStrokes.add(square);
    }

    @FXML
    public void saveCanvas() {
        ArrayList<PenStroke> clonedPenStrokes = new ArrayList<>();
        penStrokes.forEach(p -> clonedPenStrokes.add(new PenStroke(p.getLocation(), p.getColor())));
        saveStates.addState(new CanvasState(clonedPenStrokes, currentColor));
    }

    @FXML
    public void restoreLastCanvas() {
        try {
            CanvasState state = saveStates.popState();
            clearCanvas();
            loadCanvas(state.getState());
            currentColor = state.getColor();
        } catch (NoSuchElementException ignored) {
        }
    }

    private void loadCanvas(List<PenStroke> penStrokes) {
        clearCanvas();
        this.penStrokes.addAll(penStrokes);
        for (PenStroke penStroke: penStrokes) {
            drawSquare(penStroke, penStroke.getColor());
        }
    }

    @FXML
    private void clearCanvas() {
        penStrokes.clear();
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    private void drawBlack() {
        setCurrentColor(Color.BLACK);
    }

    @FXML
    private void drawRed() {
        setCurrentColor(Color.RED);
    }

    @FXML
    private void drawBlue() {
        setCurrentColor(Color.BLUE);
    }

    @FXML
    private void drawYellow() {
        setCurrentColor(Color.YELLOW);
    }

    private void drawSquare(PenStroke square) {
        Point2D location = square.getLocation();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(currentColor);
        gc.fillRect(
                location.getX() - (double) size / 2,
                location.getY() - (double) size / 2,
                size,
                size
        );
    }

    private void drawSquare(PenStroke square, Paint color) {
        Point2D location = square.getLocation();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(
                location.getX() - (double) size / 2,
                location.getY() - (double) size / 2,
                size,
                size
        );
    }

    private void setCurrentColor(Color currentColor) {
        saveCanvas();
        this.currentColor = currentColor;
    }
}
