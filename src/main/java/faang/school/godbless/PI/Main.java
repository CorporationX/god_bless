package faang.school.godbless.PI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculatePi(1000));
    }

    private static double calculatePi(int n) {
        List<CompletableFuture<Point>> futures = new ArrayList<>(n);

        ExecutorService service = Executors.newFixedThreadPool(n);

        for (int i = 0; i < n; i++) {
            futures.add(CompletableFuture.supplyAsync(() ->
                            new Point(ThreadLocalRandom.current().nextDouble(1d),
                                    ThreadLocalRandom.current().nextDouble(1d)),
                    service));
        }

        long inside = futures.stream()
                .filter(c -> {
                    try {
                        return c.thenApply((point) -> Math.pow(point.getX(), 2d)
                                        + Math.pow(point.getX(), 2d) <= 1)
                                .get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).count();

        service.shutdown();

        return (double) inside / n * 4;
    }
}
