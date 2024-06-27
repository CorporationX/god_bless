package faang.school.godbless.future.pi;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class PointCounter {

    private final AtomicInteger inside = new AtomicInteger(0);
    private final AtomicInteger all = new AtomicInteger(0);

    public void check(Point point, double radius) {
        if (point.isInside(radius)) {
            inside.incrementAndGet();
        }
        all.incrementAndGet();
    }

    public double getPi() {
        return 4.0 * inside.get() / all.get();
    }
}
