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

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Invalid input: " + n);
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Invalid input: " + n);
        }
        long factorial = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        }
        BigInteger factorial = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        AtomicInteger counter = new AtomicInteger(0);
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); i++) {
            int finalI = i;
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(() -> factorialBig(numbers.get(finalI)))
                    .whenComplete((res, ex) -> {
                        if (ex == null) {
                            counter.incrementAndGet();
                        }
                    });
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = List.of(50, 100, 18, 300, 400, 10, 25, 10000);
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < result.size(); i++) {
            CompletableFuture<BigInteger> future = result.get(i);
            int number = numbers.get(i);
            future.thenAccept(factorial -> {
                System.out.println("Factorial of " + number + ": " + factorial);
                counter.incrementAndGet();
            });
        }

        while (counter.get() != numbers.size()) {
            Thread.sleep(1000);
        }

        System.out.println("Awaited all asynchronous tasks, counter = " + counter.get());
    }

}
