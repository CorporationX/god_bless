package school.faang.BJS2_38328_Factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final ExecutorService executor = Executors.newFixedThreadPool(15);

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialBig(number)))
                .toList();
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        validateInputNumberRange(n, MAX_INT_FACTORIAL);
        int factorialResult = 1;
        for (int i = 2; i <= n; i++) {
            factorialResult *= i;
        }
        return factorialResult;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        validateInputNumberRange(n, MAX_LONG_FACTORIAL);
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        long factorialResult = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            factorialResult *= i;
        }
        return factorialResult;
    }

    public static BigInteger factorialBig(int n) {
        validatePositiveNumber(n);
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        BigInteger factorialResult = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            factorialResult = factorialResult.multiply(BigInteger.valueOf(i));
        }
        return factorialResult;
    }

    private static void validateInputNumberRange(int n, int maxValue) {
        if (n > maxValue) {
            throw new IllegalArgumentException(String.format("n must be less than or equal to %d!", maxValue));
        }
        validatePositiveNumber(n);
    }

    private static void validatePositiveNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than or equal to 0!");
        }
    }
}
