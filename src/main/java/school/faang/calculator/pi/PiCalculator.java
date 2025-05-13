package school.faang.calculator.pi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PiCalculator {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int BATCH_SIZE = 1_000;

    private final ExecutorService executor;

    public PiCalculator() {
        this.executor = Executors.newFixedThreadPool(AVAILABLE_PROCESSORS);
    }


    public double calculatePi(int totalPoints) {
        int batches = (totalPoints + BATCH_SIZE - 1) / BATCH_SIZE;

        List<CompletableFuture<Long>> futures = IntStream.range(0, batches)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    long localCount = 0;
                    int pointsInBatch = Math.min(BATCH_SIZE, totalPoints - i * BATCH_SIZE);
                    ThreadLocalRandom random = ThreadLocalRandom.current();

                    for (int j = 0; j < pointsInBatch; j++) {
                        double x = random.nextDouble(0, 1);
                        double y = random.nextDouble(0, 1);
                        Point point = new Point(x, y);
                        if (point.isInsideCircle()) {
                            localCount++;
                        }
                    }
                    return localCount;
                }, executor))
                .toList();

        long totalInside = futures.stream()
                .mapToLong(CompletableFuture::join)
                .sum();
        return 4.0 * totalInside / totalPoints;
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
