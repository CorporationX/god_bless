package faang.school.godbless.BJS2_24646;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                18, 50, 100, 200, 300, 400, 10, 25, 10000, 0
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);

        for (CompletableFuture<BigInteger> future : result) {
            future.thenAccept(number -> {
                System.out.println(number);
                counter.incrementAndGet();
            });
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(n + " is too big");
        }
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static long factorialLong(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(n + " is too big");
        }
        long result;

        if (n < MAX_INT_FACTORIAL) {
            return factorialInt(n);
        } else {
            result = factorialInt(MAX_INT_FACTORIAL);
        }

        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static BigInteger factorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + " is too small");
        }
        BigInteger result;

        if (n < MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        }

        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;

    }

    private static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); ++i) {
            int finalI = i;
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(
                    () -> factorialBig(numbers.get(finalI))
            );
            results.add(result);
        }

        return results;
    }
}
