package asyncfactorial;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletionException;
import java.util.stream.IntStream;

@UtilityClass
public class Factorial {

    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static final ExecutorService executor = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors(),
            r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
    );

    public static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Value must be between 0 and " + MAX_INT_FACTORIAL);
        }
        return IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    public static long factorialLong(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Value must be between "
                    + (MAX_INT_FACTORIAL + 1) + " and " + MAX_LONG_FACTORIAL);
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
        return numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> computeFactorialForNumber(n), executor)
                        .exceptionally(ex -> handleExceptionForFactorial(n, ex)))
                .toList();
    }

    private static BigInteger computeFactorialForNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative value not allowed: " + n);
        }
        if (n <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(n));
        } else if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            return factorialBig(n);
        }
    }

    private static BigInteger handleExceptionForFactorial(int n, Throwable ex) {
        Throwable root = ex;
        while (root instanceof CompletionException && root.getCause() != null) {
            root = root.getCause();
        }
        if (root instanceof IllegalArgumentException) {
            throw new FactorialComputationException("Failed to compute factorial for number: " + n, root);
        } else {
            throw new FactorialComputationException("Failed to compute factorial for number: " + n, ex);
        }
    }

    public static void shutdownExecutor() {
        executor.shutdown();
    }
}
