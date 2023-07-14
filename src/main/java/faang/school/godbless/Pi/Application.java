package faang.school.godbless.Pi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    static double radius = 1;
    static int all = 20000;

    public static void main(String[] args) {
        AtomicInteger inside = new AtomicInteger(0);
        List<CompletableFuture<Point>> futures = new ArrayList<>();

        for (int i = 0; i < all; i++) {

            CompletableFuture<Point> pointFuture = CompletableFuture.supplyAsync(() -> {
                Point point = generatePoint();
                if (Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= Math.pow(radius, 2)) {
                    inside.incrementAndGet();
                }
                return point;
            });
            futures.add(pointFuture);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        System.out.println((double) (4 * inside.get()) / (double) all);

    }

    static Point generatePoint() {
        return new Point(ThreadLocalRandom.current().nextDouble(radius), ThreadLocalRandom.current().nextDouble(radius));
    }
}
