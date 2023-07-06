package sprint5.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static sprint5.factorial.Factorial.findFactorials;

public class Main {
    private static final List<Integer> NUMBERS = List.of(
            1, 2, 3, 19, 21, 250, 400, 1000, 10000, -100
    );

    public static void main(String[] args) {
        List<CompletableFuture<BigInteger>> results = findFactorials(NUMBERS);
        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < results.size(); ++i) {
            CompletableFuture<BigInteger> result = results.get(i);
            processFactorialResult(result, NUMBERS.get(i), counter);
        }

        int awaitCounter = 0;
        while (counter.get() != NUMBERS.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }

    private static void processFactorialResult(CompletableFuture<BigInteger> result, int num, AtomicInteger counter) {
        CompletableFuture.runAsync(
                () -> {
                    result.thenAccept(factorial ->
                            System.out.printf("Factorial of %d = %d\n", num, factorial)
                    ).exceptionally(ex -> {
                        System.out.printf("%d cannot be processed: %s\n", num, ex.getMessage());
                        return null;
                    });
                    counter.incrementAndGet();
                });
    }
}
