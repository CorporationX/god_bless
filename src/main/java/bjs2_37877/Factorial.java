package bjs2_37877;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factorial {
    private static final int TOTAL_THREADS = 5;
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TOTAL_THREADS);

    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialBig(number), EXECUTOR_SERVICE))
                .toList();
    }

    private static BigInteger factorialBig(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(n));
        }
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        return factorialFromMaxLongToN(n).multiply(BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL)));
    }

    private static long factorialLong(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Number outside allowed factorial range");
        }

        return factorialInt(MAX_INT_FACTORIAL) * factorialFromMaxIntToN(n);
    }

    private static int factorialInt(int n) {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Exceeded max int factorial");
        }

        if (n == 0) {
            return 1;
        }

        return n * factorialInt(n - 1);
    }

    private static long factorialFromMaxIntToN(int n) {
        if (n == MAX_INT_FACTORIAL + 1) {
            return MAX_INT_FACTORIAL + 1;
        }

        return n * factorialFromMaxIntToN(n - 1);
    }

    private static BigInteger factorialFromMaxLongToN(int n) {
        if (n == MAX_LONG_FACTORIAL + 1) {
            return BigInteger.valueOf(MAX_LONG_FACTORIAL + 1);
        }
        return factorialFromMaxLongToN(n - 1).multiply(BigInteger.valueOf(n));
    }
}
