package school.faang.calculatingPhi;

import lombok.Getter;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Point {
    private final double x;
    private final double y;

    public Point(double radius) {
        this.x = ThreadLocalRandom.current().nextDouble(0, radius);
        this.y = ThreadLocalRandom.current().nextDouble(0, radius);
    }

    public static Point generateRandomPoint(double radius) {
        return new Point(radius);
    }
}
