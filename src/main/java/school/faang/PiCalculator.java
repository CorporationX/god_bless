package school.faang;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PiCalculator {
    private static final int THREAD_POOL_SIZE = 4;
    private static final double MIN_COORDINATE_VALUE = 0.0;
    private static final double MAX_COORDINATE_VALUE = 1.0;

    public double calculatePi(int n) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        long inside = IntStream.range(0, n)
                .parallel()
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    double x = ThreadLocalRandom.current().nextDouble(MIN_COORDINATE_VALUE, MAX_COORDINATE_VALUE);
                    double y = ThreadLocalRandom.current().nextDouble(MIN_COORDINATE_VALUE, MAX_COORDINATE_VALUE);
                    return new Point(x, y).isInsideCircle();
                }, executor)).map(CompletableFuture::join)
                .filter(isInside -> isInside)
                .count();

        executor.shutdown();
        return 4.0 * inside / n;
    }
}
