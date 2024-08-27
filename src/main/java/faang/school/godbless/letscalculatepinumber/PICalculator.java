package faang.school.godbless.letscalculatepinumber;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class PICalculator {
    public double calculatePi(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(n, 8));
        CompletableFuture<Long> insideCircleFuture = CompletableFuture.supplyAsync(() ->
                IntStream.range(0, n)
                        .parallel()
                        .mapToObj(i -> new Point(
                                ThreadLocalRandom.current().nextDouble(0.0, 1.0),
                                ThreadLocalRandom.current().nextDouble(0.0, 1.0)))
                        .filter(Point::isInsideCircle)
                        .count(), executorService
        );
        long insideCircle = insideCircleFuture.join();
        shutdown(executorService);
        return 4.0 * insideCircle / n;
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage(), e);
        }
    }
}