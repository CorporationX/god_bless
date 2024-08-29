package faang.school.godbless.BJS2_25049;

import java.util.concurrent.ThreadLocalRandom;

public class Point {
    private final double x;
    private final double y;
    private final double r;

    public Point() {
        x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
        y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
        r = 1.0;
    }

    public boolean isInside() {
        return x * x + y * y <= r * r;
    }
}
