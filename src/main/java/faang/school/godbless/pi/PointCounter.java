package faang.school.godbless.pi;

import java.util.concurrent.atomic.AtomicInteger;

public class PointCounter {
    private AtomicInteger inside = new AtomicInteger(0);
    private AtomicInteger all = new AtomicInteger(0);

    public void count(Point point, double radius) {
        if (point.isInside(radius)) {
            inside.incrementAndGet();
        }
        all.incrementAndGet();
    }

    public double getPi() {
        return  (double) 4 * inside.get() / all.get();
    }
}
