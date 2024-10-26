package school.faang.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Factorial out of int range");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Factorial out of long range");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream().map(f -> CompletableFuture.supplyAsync(() ->
                factorialBig(f))).toList();
    }
}
