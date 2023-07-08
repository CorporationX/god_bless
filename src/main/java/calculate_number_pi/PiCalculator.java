package calculate_number_pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class PiCalculator {
    public static double calculatePi(int n) {
        CompletableFuture<Point>[] futures = new CompletableFuture[n];

        for (int i = 0; i < n; i++) {
            CompletableFuture<Point> future = CompletableFuture.supplyAsync(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                double x = random.nextDouble();
                double y = random.nextDouble();
                return new Point(x, y);
            });
            futures[i] = future;
        }

        CompletableFuture<Long> insideCount = CompletableFuture.allOf(futures)
                .thenApplyAsync(ignored -> {
                    long count = 0;
                    for (CompletableFuture<Point> future : futures) {
                        Point point = future.join();
                        if (point.getX() * point.getX() + point.getY() * point.getY() <= 1) {
                            count++;
                        }
                    }
                    return count;
                });

        return 4.0 * insideCount.join() / (long) n;
    }
}
