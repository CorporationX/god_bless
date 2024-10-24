package school.faang.pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {
    public double calculatePi(int n) {
        List<CompletableFuture<Point>> points = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < n; i++) {
            points.add(CompletableFuture.supplyAsync(() ->
                new Point(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble())));
        }

        for (var point : points) {
            futures.add(CompletableFuture.supplyAsync(point::join)
                    .thenAccept(point1 -> CompletableFuture.runAsync(() -> {
                        if (point1.isInsideCircle()) {
                            atomicInteger.incrementAndGet();
                        }
                    })));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return (double) (4 * atomicInteger.get()) / n;
    }
}
