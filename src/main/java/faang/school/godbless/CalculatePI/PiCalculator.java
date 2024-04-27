package faang.school.godbless.CalculatePI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculator {
    private static final int MAX_N = 10;
    private static final double MAX_RADIUS = 1;

    public static void main(String[] args) {
        System.out.println(calculatePi(10_000_000));
    }

    private static double calculatePi(int n) {
        ExecutorService pool = Executors.newFixedThreadPool(Math.min(n, MAX_N));

        AtomicInteger inside = new AtomicInteger(0);
        AtomicInteger all = new AtomicInteger(0);

        List<CompletableFuture<Void>> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(
                    CompletableFuture.supplyAsync(() -> {
                        double x = ThreadLocalRandom.current().nextDouble(0.0, MAX_RADIUS);
                        double y = ThreadLocalRandom.current().nextDouble(0.0, MAX_RADIUS);
                        return new Point(x, y);
                    }, pool)
                    .thenAccept(point -> {
                        if (isInCircle(point)) {
                            inside.incrementAndGet();
                        }
                        all.incrementAndGet();
                    })
            );
        }
        pool.shutdown();

        CompletableFuture.allOf(points.toArray(CompletableFuture[]::new)).join();
        return (double) (4 * inside.get()) / all.get();
    }

    private static boolean isInCircle(Point point) {
        return Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= Math.pow(MAX_RADIUS, 2);
    }
}
