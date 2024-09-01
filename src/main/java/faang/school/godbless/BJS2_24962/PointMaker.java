package faang.school.godbless.BJS2_24962;

import java.util.concurrent.ThreadLocalRandom;

public class PointMaker {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Point generatePoint() {
        return new Point(random.nextDouble(1), random.nextDouble(1));
    }
}
