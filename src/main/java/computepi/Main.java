package computepi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 100;
    private static final int POINT_COUNT = 1000000;

    public static void main(String[] args) throws InterruptedException {
        log.info("Number PI is: " + calculatePi(POINT_COUNT));
    }

    private static double calculatePi(int n) throws InterruptedException {
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            long inCircleCount = IntStream.range(0, n)
                    .mapToObj(i -> CompletableFuture.supplyAsync(Point::new, executor))
                    .map(CompletableFuture::join)
                    .filter(Point::isInCircle)
                    .count();
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                return 4.0 * inCircleCount / n;
            } else {
                throw new RuntimeException("Time out");
            }
        }
    }
}
