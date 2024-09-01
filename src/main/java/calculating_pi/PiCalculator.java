package calculating_pi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculator {
    public static void main(String[] args) {
        System.out.println(calculatePi(1_000_000));
    }

    private static double calculatePi(int n) {
        AtomicInteger inside = new AtomicInteger(0);
        AtomicInteger all = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            futures.add(CompletableFuture.runAsync(() -> {
                Random random = ThreadLocalRandom.current();
                double x = random.nextDouble(0, 1);
                double y = random.nextDouble(0, 1);
                all.incrementAndGet();
                if (x * x + y * y <= 1) {
                    inside.incrementAndGet();
                }
            }, executorService));
        }
        executorService.shutdown();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return (double) inside.get() / all.get() * 4;
    }
}
