package faang.school.godbless.BJS2_13469;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Pi {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final int NUMBER_OF_POINTS_TO_CALCULATE_PI = 10_000_000;

    public static void main(String[] args) {
        System.out.println("Calculated Pi with " + NUMBER_OF_POINTS_TO_CALCULATE_PI + " points = " + calculatePi(NUMBER_OF_POINTS_TO_CALCULATE_PI));
    }

    private static double calculatePi(int n) {
        AtomicInteger insideCounter = new AtomicInteger(0);

        List<CompletableFuture<Point>> points = IntStream.rangeClosed(0, n)
                .mapToObj((i) -> CompletableFuture.supplyAsync(
                        () -> new Point(RANDOM.nextDouble(0.0, 1.0), RANDOM.nextDouble(0.0, 1.0)), EXECUTOR))
                .toList();

        CompletableFuture.allOf(points.toArray(new CompletableFuture[0])).join();

        EXECUTOR.shutdown();

        points.forEach(point -> point.thenRunAsync(() -> {
            try {
                if (isInside(point.get())) {
                    insideCounter.incrementAndGet();
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }));

        return (double) (4 * insideCounter.get()) / points.size();
    }

    synchronized private static boolean isInside(Point p) {
        return Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2) < 1;
    }
}
