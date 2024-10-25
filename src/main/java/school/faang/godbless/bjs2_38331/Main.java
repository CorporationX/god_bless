package school.faang.godbless.bjs2_38331;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Integer> numbers = List.of(23, 1, 5, 12, 19);
        List<CompletableFuture<BigInteger>> factorials = Factorial.factorials(numbers, pool);
        AtomicInteger countFinished = new AtomicInteger(0);
        IntStream.range(0, factorials.size()).forEach(index ->
                CompletableFuture.runAsync(() -> {
                    BigInteger factorialValue = factorials.get(index).join();
                    log.info("Thread {} : {}! = {}", Thread.currentThread().getName(), numbers.get(index), factorialValue);
                    countFinished.incrementAndGet();
                }, pool)
        );
        while (countFinished.get() != numbers.size()) {
        }
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            log.info("Program finished");
        } else {
            log.error("The pool is not terminated");
        }
    }
}
