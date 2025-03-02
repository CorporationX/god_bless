package bjs2_62067;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PiValueCalculator {
    public static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() + 1;
    public static final int WAITING_TERMINATION_TIMEOUT_SECONDS = 1;

    public static double calculatePi(int n) {
        var executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<CompletableFuture<Boolean>> futures = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            futures.add(CompletableFuture.supplyAsync(PiValueCalculator::generatePoint, executor));
        }
        executor.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        var insideCount = futures.stream()
                .map(CompletableFuture::join)
                .filter(isInside -> isInside)
                .count();

        try {
            if (!executor.awaitTermination(WAITING_TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Не дождались завершения потоков за заданное время");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.info("Не дождались завершения потоков за заданное время: {}", e.getMessage(), e);
        }

        log.info("Внутри точек {} из {}", insideCount, n);

        return 4.0 * insideCount / n;
    }

    private static boolean generatePoint() {
        var random = ThreadLocalRandom.current();

        var x = random.nextDouble();
        var y = random.nextDouble();
        var point = new Point(x, y);

        return point.isInsideCircle();
    }
}
