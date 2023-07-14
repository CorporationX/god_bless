package faang.school.godbless.kxnvg.pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PiRunner {

    private static final int NUMBER_OF_POINTS = 10000;

    public static void main(String[] args) {
        PiRunner runner = new PiRunner();
        System.out.println(runner.calculatePi(NUMBER_OF_POINTS));
    }

    public double calculatePi(int n) {
        List<Point> allPoints = new ArrayList<>();
        List<Point> insidePoints = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        AtomicInteger all = new AtomicInteger(0);
        AtomicInteger inside = new AtomicInteger(0);

        for (int i = 0; i < n; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                double x = ThreadLocalRandom.current().nextDouble(1);
                double y = ThreadLocalRandom.current().nextDouble(1);
                allPoints.add(new Point(x, y));
                all.incrementAndGet();
                if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                    insidePoints.add(new Point(x, y));
                    inside.incrementAndGet();
                }
            });
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("inside = " + inside.get());
        System.out.println("all = " + all.get());

        double pi = 4 * (double) inside.get() / (double) all.get();
        return pi;
    }
}
