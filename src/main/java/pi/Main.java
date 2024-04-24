package pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int AMOUNT_OF_POINTS = 100_000_000;
    private static final double RADIUS = 1;

    public static void main(String[] args) {
        System.out.println("PI = " + calculatePi(AMOUNT_OF_POINTS));
    }

    static double calculatePi(int n) {
        ExecutorService service = Executors.newCachedThreadPool();

        long inside = IntStream.range(0, n).parallel()
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    double x = ThreadLocalRandom.current().nextDouble(0, 1);
                    double y = ThreadLocalRandom.current().nextDouble(0, 1);
                    return new Point(x, y);
                }, service))
                .filter(point -> {
                    try {
                        return Math.pow(point.get().getX(), 2) + Math.pow(point.get().getX(), 2) <= Math.pow(RADIUS, 2);
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .count();

        service.shutdown();

        try {
            service.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return 4.0 * inside / n;
    }

}
