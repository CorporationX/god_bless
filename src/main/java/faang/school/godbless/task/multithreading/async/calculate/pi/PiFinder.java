package faang.school.godbless.task.multithreading.async.calculate.pi;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class PiFinder {
    private static final int RADIOS = 1;

    private final AtomicInteger all = new AtomicInteger();
    private final AtomicInteger inside = new AtomicInteger();
    private final ExecutorService executor;

    public PiFinder(int threadPoolSize) {
        executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public CompletableFuture<Void> allocatePoint(Point point) {
        return CompletableFuture.runAsync(() -> allocate(point), executor);
    }

    private void allocate(Point point) {
        if (isInside(point)) {
            inside.incrementAndGet();
        }
        all.incrementAndGet();
    }

    private boolean isInside(Point point) {
        double x = point.x();
        double y = point.y();
        return (x * x) + (y * y) <= RADIOS * RADIOS;
    }

    public double calculatePi() {
        return 4.0 * inside.get() / all.get();
    }
}
