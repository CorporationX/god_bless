package school.faang.task_49370;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class GameObject {
    private final Shape coordinates;

    protected GameObject() {
        this.coordinates = setObjectCoordinates();
    }

    Shape setObjectCoordinates(){
        Shape e = new Rectangle2D.Double(
                Math.random()*100,
                Math.random()*100,
                Math.random()*100,
                Math.random()*100);;

        return e;
    }
}
