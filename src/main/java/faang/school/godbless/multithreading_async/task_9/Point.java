package faang.school.godbless.multithreading_async.task_9;

import java.util.concurrent.ThreadLocalRandom;

public class Point {
    private final double x;
    private final double y;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public Point() {
        this.x = RANDOM.nextDouble(-1.0, 1.0);
        this.y = RANDOM.nextDouble(-1.0, 1.0);
    }

    public boolean isInside() {
        return x * x + y * y <= 1.0;
    }
}
