package faang.school.godbless.asynchronism.task9;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculatePi(100000));
    }

    private static double calculatePi(int n) {
        ExecutorService service = Executors.newFixedThreadPool(Math.min(n, 8));
        AtomicInteger inside = new AtomicInteger(0);

        List<CompletableFuture<Void>>  completableFutures = IntStream.range(0, n)
                .parallel()
                .mapToObj((i) -> CompletableFuture.supplyAsync(() -> {
                                    double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                                    double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                                    return new Point(x, y);
                                }, service)
                        .thenAcceptAsync(point -> {
                            if (point.getX() * point.getX() + point.getY() * point.getY() < 1) {
                                inside.incrementAndGet();
                            }
                        }, service)
                )
                .toList();
        CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new)).join();
        service.shutdown();
        return 4 * inside.get()/(n * 1.0);
    }
}
