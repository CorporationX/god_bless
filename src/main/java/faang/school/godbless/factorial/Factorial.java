package faang.school.godbless.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        if (n < MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static BigInteger factorialBig(int n) {
        if (n < MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
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

    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );

        List<CompletableFuture<BigInteger>> result = factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < result.size(); ++i) {
            int finalI = i;
            new Thread(
                    () -> {
                        try {
                            result.get(finalI).get();
                            counter.incrementAndGet();
                        } catch (InterruptedException | ExecutionException e) {
                            System.out.println("Interrupted");
                        }
                    }
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }
}
