package faang.school.godbless.sprint4.calculate_pi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    private static final int TOTAL_POINTS = 10000000;
    private static final AtomicInteger innerPoints = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.printf("Approximation to PI: %f", calculatePi(TOTAL_POINTS));
    }

    public static double calculatePi(int totalPoints) {
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(TOTAL_POINTS, 10));
        List<CompletableFuture<Void>> futures = Stream.generate(RandomPoint::new)
                .limit(totalPoints)
                .map(randomPoint -> CompletableFuture.runAsync(() -> {
                    if (randomPoint.isInside()) {
                        innerPoints.incrementAndGet();
                    }
                }, executor))
                .toList();

        executor.shutdown();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        return 4 * innerPoints.doubleValue() / TOTAL_POINTS;
    }
}
