package school.faangSprint4.t17;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    private static final int DEFAULT_NUMBER_OF_POINTS = 1_000_000;
    private static final int MAX_THREAD_POOL_SIZE = 8;
    private static final double RANDOM_RANGE_MIN = 0.0;
    private static final double RANDOM_RANGE_MAX = 1.0;
    private static final double PI_MULTIPLIER = 4.0;
    private static final String RESULT_FORMAT = "Approximated Pi value with %d points: %.10f%n";
    private static final String ACTUAL_PI_FORMAT = "Actual Pi value: %.10f%n";
    private static final String DIFFERENCE_FORMAT = "Difference: %.10f%n";

    public static void main(String[] args) {
        double pi = calculatePi(DEFAULT_NUMBER_OF_POINTS);
        System.out.printf(RESULT_FORMAT, DEFAULT_NUMBER_OF_POINTS, pi);
        System.out.printf(ACTUAL_PI_FORMAT, Math.PI);
        System.out.printf(DIFFERENCE_FORMAT, Math.abs(Math.PI - pi));
    }

    @SuppressWarnings("unchecked")
    static double calculatePi(int n) {
        ExecutorService service = Executors.newFixedThreadPool(Math.min(n, MAX_THREAD_POOL_SIZE));
        AtomicInteger pointsInsideCircle = new AtomicInteger(0);

        try {
            CompletableFuture<Void>[] futures = IntStream.range(0, n)
                    .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                                double x = ThreadLocalRandom.current().nextDouble(RANDOM_RANGE_MIN, RANDOM_RANGE_MAX);
                                double y = ThreadLocalRandom.current().nextDouble(RANDOM_RANGE_MIN, RANDOM_RANGE_MAX);
                                return new Point(x, y);
                            }, service)
                            .thenAccept(point -> {
                                if (point.isInsideCircle()) {
                                    pointsInsideCircle.incrementAndGet();
                                }
                            }))
                    .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(futures).join();

            return PI_MULTIPLIER * pointsInsideCircle.get() / n;
        } finally {
            service.shutdown();
        }
    }
}