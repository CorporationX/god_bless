package faang.school.godbless.future.pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static final double RADIUS = 1.0;
    public static final int THREADS = 5;
    public static final int POINTS = 10_000_000;
    public static final int TIMEOUT = 10;

    public static void main(String[] args) {

        System.out.println(calculatePi(RADIUS));
    }

    public static double calculatePi(double radius) {

        PointGenerator pointGenerator = new PointGenerator();
        PointCounter pointCounter = new PointCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        IntStream.rangeClosed(1, POINTS)
                .forEach(i -> CompletableFuture.runAsync(() -> {
                    Point point = pointGenerator.getPoint(radius);
                    pointCounter.check(point, radius);
                }, executorService));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                throw new RuntimeException("Failed to await termination");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Points inside: " + pointCounter.getInside() + ". All: " + pointCounter.getAll());
        return pointCounter.getPi();
    }
}
