import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SaveRepo {

    List<Canvas> states = new ArrayList<Canvas>();

    public void addState(Canvas c) {
        states.add(c);
    }

    public Canvas popState() {
        Canvas state = states.get(states.size() - 1);
        states.remove(states.size() - 1);
        return state;
    }

}
