import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class PenStroke {

    private final Point2D location;
    private final Color color;

    public PenStroke(Point2D location, Color color) {
        this.location = location;
        this.color = color;
    }

    public Point2D getLocation() {
        return location;
    }

    public Color getColor() {
        return color;
    }

}
