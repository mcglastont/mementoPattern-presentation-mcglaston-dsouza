import java.awt.*;

public class DrawController {

    private SaveRepo savestates;
    private Canvas canvas;

    public void draw() {

    }

    public void saveCanvas() {
        savestates.addState(canvas);
    }

    public void restoreLastCanvas() {
        canvas = savestates.popState();
    }

}
