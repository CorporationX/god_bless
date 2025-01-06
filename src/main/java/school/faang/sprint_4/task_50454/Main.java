package school.faang.sprint_4.task_50454;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int AWAIT_TIME_MINUTES = 1;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 3, 455, 16, 100, 244, 5);
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            List<CompletableFuture<BigInteger>> result = Factorial.factorials(numbers);
            for (int i = 0; i < result.size(); ++i) {
                int index = i;
                executor.submit(() -> {
                    try {
                        BigInteger factorial = result.get(index).get();
                        log.info("Factorial of a number {} = {}", numbers.get(index), factorial);
                        counter.incrementAndGet();
                    } catch (Exception e) {
                        log.error("Error message: ", e);
                    }
                });
            }

            int awaitCounter = 0;
            while (counter.get() != numbers.size()) {
                awaitCounter++;
            }
            log.info("All tasks are completed. Waiting iterations: {}", awaitCounter);

            executor.shutdown();
            if (!executor.awaitTermination(AWAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (Exception e) {
            log.error("Error message: ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
