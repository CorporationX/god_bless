package faang.school.godbless.pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREADS = 8;
    private static final double RADIUS = 1.0;
    private static final int POINTS = 5_000_000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        PointCounter pointCounter = new PointCounter();

        IntStream.rangeClosed(0, POINTS).forEach(num -> CompletableFuture.runAsync(() -> {
            double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            Point point = new Point(x, y);
            pointCounter.count(point, RADIUS);
        }, executorService));

        executorService.shutdown();

        try {
            executorService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(pointCounter.getPi());
    }
}
