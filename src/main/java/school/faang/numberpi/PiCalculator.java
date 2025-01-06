package school.faang.numberpi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculator {
    public double calculatePi(int n) {
        ExecutorService service = Executors.newFixedThreadPool(Math.min(n, Runtime.getRuntime().availableProcessors()));
        AtomicInteger inside = new AtomicInteger(0);
        CompletableFuture<?>[] futures = new CompletableFuture[n];

        for (int i = 0; i < n; i++) {
            futures[i] = CompletableFuture.runAsync(() -> {
                Point point = new Point();
                if (point.isInsideCircle()) {
                    inside.incrementAndGet();
                }
            }, service);
        }
        CompletableFuture.allOf(futures).join();
        service.shutdown();

        return 4.0 * inside.get() / n;
    }
}
