package school.faang.lets_calculate_the_number_of_pIs.BJS2_62125;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class PiCalculator {
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    private static final double MIN_COORDINATE_VALUE = 0.0;
    private static final double MAX_COORDINATE_VALUE = 1.0;

    public double calculatePi(int n) {
        double inside = IntStream.range(0, n)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    Point point = new Point(
                            ThreadLocalRandom.current().nextDouble(MIN_COORDINATE_VALUE, MAX_COORDINATE_VALUE),
                            ThreadLocalRandom.current().nextDouble(MIN_COORDINATE_VALUE, MAX_COORDINATE_VALUE));
                    return point.isInsideCircle();
                }, threadPool))
                .map(CompletableFuture::join)
                .filter(isInsideCircle -> isInsideCircle)
                .count();

        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(1, TimeUnit.MINUTES)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted while waiting for thread pool to terminate", e);
            threadPool.shutdownNow();
        }

        return 4 * inside / n;
    }
}
