package school.faang.BJS2_38362_PI;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@AllArgsConstructor
public class PiEstimator {
    private static final double EPSILON = 1e-10;

    private double radius;

    public double calculatePi(int n) {
        AtomicInteger pointsInsideCount = new AtomicInteger();
        return CompletableFuture.allOf(
                        IntStream.rangeClosed(1, n)
                                .mapToObj(
                                        i -> CompletableFuture.runAsync(
                                                () -> {
                                                    Point point = randomPoint();
                                                    countPointIfInside(point, pointsInsideCount);
                                                })
                                )
                                .toArray(CompletableFuture[]::new)
                )
                .thenApply(v -> getPi(pointsInsideCount.get(), n))
                .join();
    }

    private double getPi(int insidePoints, int allPoints) {
        return 4.0 * insidePoints / allPoints;
    }

    private void countPointIfInside(Point point, AtomicInteger pointsInsideCount) {
        if (point.isInsideCircle(radius)) {
            pointsInsideCount.incrementAndGet();
        }
    }

    private Point randomPoint() {
        double x = ThreadLocalRandom.current().nextDouble(-radius, radius + EPSILON);
        double y = ThreadLocalRandom.current().nextDouble(-radius, radius + EPSILON);
        return new Point(x, y);
    }
}
