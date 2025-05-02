package school.faang.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static school.faang.factorial.ThreadPoolProvider.executor;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(String.format("number must be between 0 and %d", MAX_INT_FACTORIAL));
        }
        if (n <= 1) {
            return n;
        }
        return n * factorialInt(n - 1);
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(String.format("number must be between 0 and %d", MAX_LONG_FACTORIAL));
        }
        if (n <= 1) {
            return n;
        }
        return n * factorialLong(n - 1);
    }

    static BigInteger factorialBig(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("number must be greater than 0");
        }
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        return BigInteger.valueOf(n).multiply(factorialBig(n - 1));
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .map(num -> CompletableFuture.supplyAsync(() -> {
                    if (num < MAX_INT_FACTORIAL) {
                        return BigInteger.valueOf(factorialInt(num));
                    } else if (num < MAX_LONG_FACTORIAL) {
                        return BigInteger.valueOf(factorialLong(num));
                    }
                    return factorialBig(num);
                }, executor))
                .toList();
    }
}
