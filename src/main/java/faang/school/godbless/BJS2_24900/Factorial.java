package faang.school.godbless.BJS2_24900;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        ExecutorService executor = Executors.newFixedThreadPool(numbers.size());
        List<CompletableFuture<BigInteger>> futures = numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(
                        () -> factorialBig(number), executor))
                .toList();
        shutdown(executor);
        return futures;
    }

    private static BigInteger factorialBig(int number) {
        if (number <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(number));
        } else {
            BigInteger acc = BigInteger.valueOf(factorialLong(MAX_INT_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL + 1; i <= number; i++) {
                acc = acc.multiply(BigInteger.valueOf(i));
            }
            return acc;
        }
    }

    private static long factorialLong(int number) throws IllegalArgumentException {
        if (number <= MAX_INT_FACTORIAL) {
            return factorialInt(number);
        } else {
            return IntStream.rangeClosed(MAX_INT_FACTORIAL + 1, number)
                    .reduce(factorialInt(MAX_INT_FACTORIAL), (a, b) -> a * b);
        }
    }

    private static int factorialInt(int number) throws IllegalArgumentException {
        return IntStream.rangeClosed(1, number)
                .reduce(1, (a, b) -> a * b);
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
