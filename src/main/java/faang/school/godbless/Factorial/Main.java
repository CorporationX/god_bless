package faang.school.godbless.Factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                5, 50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = Factorial.factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);
        for (CompletableFuture<BigInteger> future : result) {
            new Thread(
                    () -> {
                        future.thenAccept(res -> log.info(res.toString()));
                        counter.incrementAndGet();
                    }
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        log.info("Awaited all asynchronous tasks, counter = {}", awaitCounter);
    }
}
