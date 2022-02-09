import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PenStroke {

    private final Point2D location;
    private final Paint color;

    public PenStroke(Point2D location, Paint color) {
        this.location = location;
        this.color = color;
    }

    public Point2D getLocation() {
        return location;
    }

    public Paint getColor() {
        return color;
    }

}
