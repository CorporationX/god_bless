package faang.school.godbless.BJS2_1355;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static final int ALL_POINT = 100_000;
    public static final int CYCLE_RADIUS = 1;
    public static AtomicInteger inside = new AtomicInteger(0);

    public static void main(String[] args) {
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(1_000);

        for (int i = 0; i < ALL_POINT; i++) {
            double x = generateDouble();
            double y = generateDouble();
            Point point = new Point(x, y);
            completableFutures.add(operateIfInsidePoint(point, CYCLE_RADIUS, executor));
        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        double pi = 4 * (double) inside.get() / ALL_POINT;

        System.out.printf("All points count: %s, Points inside cycle: %s. Calculated pi is %s.6", ALL_POINT, inside, pi);
    }

    public static CompletableFuture<Void> operateIfInsidePoint(Point point, double cycleRadius, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            if (isInsideCycle(point, cycleRadius)) {
                inside.incrementAndGet();
            }
        }, executor);
    }

    public static double generateDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static boolean isInsideCycle(Point point, double cycleRadius) {
        double x = point.getX();
        double y = point.getY();
        return (x * x + y * y) <= (cycleRadius * cycleRadius);
    }
}