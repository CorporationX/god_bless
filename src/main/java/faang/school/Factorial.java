package faang.school;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(n + "! is to big for int");
        }
        if (n == 1) return 1;
        return n * factorialInt(n - 1);
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(n + "! is to big for long");
        }
        if (n <= MAX_INT_FACTORIAL) {
            return (long) n * factorialInt(n - 1);
        }
        return n * factorialLong(n - 1);
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(n * factorialLong(n - 1));
        }
        return factorialBig(n - 1).multiply(BigInteger.valueOf(n));
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialBig(number)))
                .toList();
    }
}
