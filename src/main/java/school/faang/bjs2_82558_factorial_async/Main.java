package school.faang.bjs2_82558_factorial_async;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 9, 12, 15, 19, 20, 25);
        List<CompletableFuture<BigInteger>> factorialPromises = Factorial.factorials(numbers);

        AtomicInteger completedTasks = new AtomicInteger(0);
        awaitCalcAndIncrementCompletedCounterAsync(factorialPromises, completedTasks);

        while (completedTasks.get() < numbers.size()) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        log.info("All factorial calculations completed");
    }

    private static void awaitCalcAndIncrementCompletedCounterAsync(
            List<CompletableFuture<BigInteger>> futures,
            AtomicInteger completedCounter) {
        futures.forEach(
                f -> CompletableFuture.supplyAsync(
                        () -> {
                            BigInteger value = f.join();
                            log.info("New factorial value received: {}", value);
                            return completedCounter.incrementAndGet();
                        }
                )
        );
    }
}
