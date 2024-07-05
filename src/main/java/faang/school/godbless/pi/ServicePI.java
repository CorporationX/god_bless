package faang.school.godbless.pi;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public final class ServicePI {
    private static final AtomicInteger INSIDE = new AtomicInteger();
    private static final AtomicInteger ALL_MEASUREMENTS = new AtomicInteger();
    private static final Random RANDOM = new Random();
    private static final Integer RADIUS = 1;

    public void studyGettingPointIntoCircle() {
        double x = RANDOM.nextDouble(0, 1);
        double y = RANDOM.nextDouble(0, 1);
        if (x * x + y * y <= RADIUS * RADIUS) {
            INSIDE.getAndIncrement();
        }
        ALL_MEASUREMENTS.getAndIncrement();
    }

    public int getInside() {
        return INSIDE.get();
    }

    public int getAll() {
        return ALL_MEASUREMENTS.get();
    }
}
