package school.faangSprint4.t18;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final int TIME_SLEEP = 100;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 10, 15, 20, 25);
        List<CompletableFuture<BigInteger>> futures = factorials(numbers);
        AtomicInteger completedTasks = new AtomicInteger(0);

        for (int i = 0; i < futures.size(); i++) {
            final int index = i;
            CompletableFuture<BigInteger> future = futures.get(i);

            new Thread(() -> {
                try {
                    BigInteger result = future.get();
                    System.out.printf("Factorial of %d = %s%n", numbers.get(index), result);
                    completedTasks.incrementAndGet();
                } catch (Exception e) {
                    System.out.printf("Error calculating factorial for %d: %s%n",
                            numbers.get(index), e.getMessage());
                    completedTasks.incrementAndGet();
                }
            }).start();
        }

        while (completedTasks.get() < futures.size()) {
            try {
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("All calculations completed!");
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Number is too large for int factorial. Use factorialLong or factorialBig");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Number is too large for long factorial. Use factorialBig");
        }
        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); i++) {
            int finalI = i;
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(
                    () -> factorialBig(numbers.get(finalI))
            );
            results.add(result);
        }
        return results;
    }
}