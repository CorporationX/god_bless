package count_pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class PiCalculator {

    public static CompletableFuture<Double> calculatePi(int n) {
        AtomicLong insideCircleCount = new AtomicLong(0);

        CompletableFuture<?>[] futures = IntStream.range(0, n)
                .mapToObj(i ->
                        CompletableFuture.supplyAsync(() -> {
                                    double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                                    double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                                    return new Point(x, y);
                                })
                                .thenAccept(point -> {
                                    if (point.isInsideCircle()) {
                                        insideCircleCount.incrementAndGet();
                                    }
                                }))
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(futures)
                .thenApplyAsync(ignored -> 4.0 * insideCircleCount.get() / n);
    }

    public static void main(String[] args) {
        int numberOfPoints = 1000000;

        calculatePi(numberOfPoints)
                .thenAccept(pi -> System.out.println("Approximate value of Pi: " + pi))
                .join();
    }
}
