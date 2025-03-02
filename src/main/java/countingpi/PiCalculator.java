package countingpi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class PiCalculator {
    public static void calculatePi(int points) {
        AtomicInteger insideCirclePointsCount = new AtomicInteger(0);
        log.info("Starting Pi calculation with {} points", points);

        CompletableFuture<?>[] futures = IntStream.range(0, points)
                .mapToObj(pointIndex -> CompletableFuture.supplyAsync(() -> {
                    double x = ThreadLocalRandom.current().nextDouble(0, 1);
                    double y = ThreadLocalRandom.current().nextDouble(0, 1);
                    return new Point(x, y);
                }).thenAccept(point -> {
                    if (point.isInsideCircle()) {
                        insideCirclePointsCount.incrementAndGet();
                    }
                }))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        double pi = 4.0 * insideCirclePointsCount.get() / points;
        log.info("Calculated Pi value: {}", pi);
    }
}
