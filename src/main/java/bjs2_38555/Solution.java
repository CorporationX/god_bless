package bjs2_38555;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    private final ExecutorService service;
    private final ThreadLocalRandom random;
    private final int threads;

    public Solution(int threads) {
        this.threads = threads;
        this.random = ThreadLocalRandom.current();
        this.service = Executors.newFixedThreadPool(threads);
    }

    public double calculatePi(int n) {
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        int forOneThread = n / threads;

        for (int i = 0; i < threads; i++) {
            if (i == threads - 1) {
                int forLastThread = n - forOneThread * (threads - 1);
                futures.add(countPoints(forLastThread));
                break;
            }
            futures.add(countPoints(forOneThread));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        service.shutdown();

        int inside = futures.stream()
                .mapToInt(CompletableFuture::join)
                .sum();

        return 4.0 * inside / n;
    }

    public CompletableFuture<Integer> countPoints(int n) {
        return CompletableFuture.supplyAsync(() -> {
            int inside = 0;
            for (int i = 0; i < n; i++) {
                Point point = new Point(random.nextDouble(), random.nextDouble());
                if (point.isInsideCircle()) {
                    inside++;
                }
            }
            return inside;
        }, service);
    }

    public double calculatePiContinuously(int n) {
        int inside = 0;
        for (int i = 0; i < n; i++) {
            Point point = new Point(random.nextDouble(), random.nextDouble());
            if (point.isInsideCircle()) {
                inside++;
            }
        }
        return 4.0 * inside / n;
    }
}
