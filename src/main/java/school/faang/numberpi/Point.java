package school.faang.numberpi;

import java.util.concurrent.ThreadLocalRandom;

public final class Point {
    private final double coordinateX;
    private final double coordinateY;

    public Point() {
        coordinateX = ThreadLocalRandom.current().nextDouble();
        coordinateY = ThreadLocalRandom.current().nextDouble();
    }

    public boolean isInsideCircle() {
        return coordinateX * coordinateX + coordinateY * coordinateY <= 1;
    }
}
