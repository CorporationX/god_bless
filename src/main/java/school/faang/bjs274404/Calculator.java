package school.faang.bjs274404;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Calculator {
    private static final int THREAD_COUNT = 10;
    private static final int SHUTDOWN_TIME = 10;

    private final AtomicInteger inside = new AtomicInteger(0);
    private final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    public double calculatePi(int pointsCount) {
        List<CompletableFuture<Void>> points = generatePoints(pointsCount);
        CompletableFuture.allOf(points.toArray(new CompletableFuture[0])).join();
        shutdown();

        return (double) (4 * inside.get()) / pointsCount;
    }

    private List<CompletableFuture<Void>> generatePoints(int pointsCount) {
        List<CompletableFuture<Void>> points = new ArrayList<>(pointsCount);
        for (int i = 0; i < pointsCount; i++) {
            points.add(generatePoint());
        }

        return points;
    }

    private CompletableFuture<Void> generatePoint() {
        return CompletableFuture.runAsync(() -> {
            Point point = new Point(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
            updateCounter(point);
        }, threadPool);
    }

    public void updateCounter(Point point) {
        if (!point.isInsideCircle()) {
            return;
        }
        inside.incrementAndGet();
    }

    private void shutdown() {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(SHUTDOWN_TIME, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Pi calculation interrupted: {}", e.getMessage());
        }
    }
}
