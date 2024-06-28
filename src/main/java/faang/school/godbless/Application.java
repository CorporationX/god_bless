package faang.school.godbless;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Application {

    private static final int COUNT_POINTS = 10_000_000;
    private static final Circle CIRCLE = new Circle(new Point(0, 0), 1d);

    private static boolean isInsideCircle(@NonNull Point p, @NonNull Circle c) {
        return Math.pow(p.x() - c.center().x(), 2) + Math.pow(p.y() - c.center().y(), 2) <= c.radius();
    }

    private static double calculatePi(int executorCount) {
        ExecutorService pool = Executors.newFixedThreadPool(executorCount);

        CompletableFuture<Boolean>[] futures = IntStream
                .range(0, COUNT_POINTS)
                .mapToObj(tmp -> CompletableFuture.supplyAsync(() -> {
                                    double x = ThreadLocalRandom.current()
                                            .nextDouble(0, 1 + Double.MIN_VALUE);
                                    double y = ThreadLocalRandom.current()
                                            .nextDouble(0, 1 + Double.MIN_VALUE);
                                    Point p = new Point(x, y);
                                    return isInsideCircle(p, CIRCLE);
                                }, pool
                        )
                ).toArray(CompletableFuture[]::new);

        long inside = CompletableFuture.allOf(futures).thenApplyAsync(thm ->
                IntStream.range(0, COUNT_POINTS)
                        .filter(i -> futures[i].join())
                        .count()
        ).join();


        pool.shutdown();

        return (double) (4 * inside) / COUNT_POINTS;
    }

    public static void main(String[] args) {

        int cpuCount = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = cpuCount * 2 + 1;

        double calculatedPi = calculatePi(maximumPoolSize);

        System.out.println("Calculated value: " + calculatedPi);
        System.out.println("Actual value:" + Math.PI);
        System.out.println("Calculation accuracy: " + Math.PI/calculatedPi);
    }
}