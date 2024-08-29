package factorial;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                1, 2, 3, 6, 15, 50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            int finalI = i;
            new Thread(
                    () -> {
                        result.get(finalI).join();
                        counter.getAndIncrement();
                    }
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        log.info("Awaited all asynchronous tasks, counter = " + awaitCounter);
        for (int i = 0; i < result.size(); i++) {
            log.info(numbers.get(i) + " : " + result.get(i).join());
        }
    }

    private static List<CompletableFuture<BigInteger>> factorials(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(num -> CompletableFuture.supplyAsync(() -> Factorial.factorialBig(num)))
                .toList();
    }
}
