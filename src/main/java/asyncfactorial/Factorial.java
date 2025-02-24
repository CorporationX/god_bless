package asyncfactorial;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@UtilityClass
public class Factorial {

    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Value must be between 0 and " + MAX_INT_FACTORIAL);
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Value must be between " + (MAX_INT_FACTORIAL + 1)
                    + " and " + MAX_LONG_FACTORIAL);
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
                .map(n -> CompletableFuture.supplyAsync(() -> {
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
                }))
                .toList();
    }
}
