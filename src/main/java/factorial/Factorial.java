package factorial;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

@UtilityClass
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 1 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(
                    "Integer number must be greater than 0 and less than " + MAX_INT_FACTORIAL + 1);
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static long factorialLong(int n) throws IllegalArgumentException {
        if (n < 1 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(String.format(
                    "Long Integer number must be greater than 0 and less than %d",
                    MAX_LONG_FACTORIAL + 1));
        }
        var intFactorial = CompletableFuture.supplyAsync(() -> factorialInt(Math.min(MAX_INT_FACTORIAL, n)));
        long result = 1;
        for (long i = MAX_INT_FACTORIAL + 1L; i <= n; i++) {
            result *= i;
        }
        return result * intFactorial.join();
    }

    public static BigInteger factorialBig(int n) throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        var longFactorial = CompletableFuture.supplyAsync(() -> factorialLong(Math.min(MAX_LONG_FACTORIAL, n)));
        BigInteger result = BigInteger.valueOf(1L);
        for (long i = MAX_LONG_FACTORIAL + 1L; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result.multiply(BigInteger.valueOf(longFactorial.join()));
    }
}
