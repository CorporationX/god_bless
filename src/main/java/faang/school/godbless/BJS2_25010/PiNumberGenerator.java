package faang.school.godbless.BJS2_25010;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PiNumberGenerator {
    public static final PiNumberGenerator INSTANCE = new PiNumberGenerator();
    private AtomicInteger inside = new AtomicInteger(0);

    public double calculatePi(int n) {
        ExecutorService executor = Executors.newFixedThreadPool(n);

        var futures = IntStream.range(0, n)
                .mapToObj(i -> CompletableFuture.runAsync(
                        () -> calculate(generatePoint()), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        int inside = this.inside.get();
        destroy(executor, n);

        return 4.0 * inside / n;
    }

    private Point generatePoint() {
        return new Point(next(), next());
    }

    private double next() {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0);
    }

    private void calculate(Point point) {
        if (isInCircle(point.getX(), point.getY())) {
            inside.incrementAndGet();
        }
    }

    private boolean isInCircle(double x, double y) {
        double R = 1.0;
        return (x * x + y * y) <= R * R;
    }

    private void destroy(ExecutorService executor, int n) {
        inside = new AtomicInteger(0);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(n, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
