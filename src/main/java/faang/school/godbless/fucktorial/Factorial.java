package faang.school.godbless.fucktorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        if (n >= 0 && n <= MAX_INT_FACTORIAL) {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL && n <= MAX_LONG_FACTORIAL) {
            long l = MAX_INT_FACTORIAL + 1;
            for (int i = MAX_INT_FACTORIAL + 2; i <= n; i++) {
                l *= i;
            }
            return factorialInt(MAX_INT_FACTORIAL) * l;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static BigInteger factorialBig(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(n));
        } else if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            BigInteger result = BigInteger.valueOf(MAX_LONG_FACTORIAL + 1);
            for (int i = MAX_LONG_FACTORIAL + 2; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result.multiply(BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL)));
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger();
        for (int i = 0; i < result.size(); ++i) {
            int finalI = i;
            new Thread(
                    () -> result.get(finalI).thenRun(() -> counter.addAndGet(1))
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> futures = new ArrayList<>(numbers.size());

        for (Integer integer : numbers) {
            futures.add(
                    CompletableFuture.supplyAsync(() -> factorialBig(integer))
            );
        }

        return futures;
    }
}
