package faang.school.godbless.BJS225138;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Point {
    private static final double RADIUS = 1.0;

    private final double x;
    private final double y;
    private final boolean isInCircle;

    public Point() {
        x = ThreadLocalRandom.current().nextDouble(1.0);
        y = ThreadLocalRandom.current().nextDouble(1.0);
        isInCircle = Math.pow(x, 2) + Math.pow(y, 2) <= RADIUS;
    }
}
