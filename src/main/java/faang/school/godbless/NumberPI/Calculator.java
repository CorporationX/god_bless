package faang.school.godbless.NumberPI;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@Slf4j
public class Calculator {
    public double calculatePi(int n) {
        List<CompletableFuture<Boolean>> futures = IntStream.range(0, n)
                .parallel()
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    double x = ThreadLocalRandom.current().nextDouble(1.0);
                    double y = ThreadLocalRandom.current().nextDouble(1.0);
                    return x * x + y * y <= 1.0;
                }))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long insideCount = futures.stream()
                .filter(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error(e.getMessage());
                        return false;
                    } catch (ExecutionException e) {
                        log.error(e.getMessage());
                        return false;
                    }
                })
                .count();

        return 4.0 * insideCount / n;
    }
}
