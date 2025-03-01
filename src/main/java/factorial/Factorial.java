package factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Factorial {
    private static final int MAX_INT = 12;
    private static final int MAX_LONG = 19;

    public static int factorialInt(int n) {
        validate(n, MAX_INT);
        return IntStream.rangeClosed(1, n).reduce(1, Math::multiplyExact);
    }

    public static long factorialLong(int n) {
        validate(n, MAX_LONG);

        if (n <= MAX_INT) {
            return factorialInt(n);
        }
        return LongStream.rangeClosed(MAX_INT + 1, n)
                .reduce(factorialInt(MAX_INT), Math::multiplyExact);
    }

    public static BigInteger factorialBig(int n) {
        validate(n, Integer.MAX_VALUE);

        if (n <= MAX_LONG) {
            return BigInteger.valueOf(factorialLong(n));
        }
        return LongStream.rangeClosed(MAX_LONG + 1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.valueOf(factorialLong(MAX_LONG)), BigInteger::multiply);
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> calculate(n)))
                .toList();
    }

    private static BigInteger calculate(int n) {
        try {
            if (n < 0) {
                throw new IllegalArgumentException();
            }
            if (n <= MAX_INT) {
                return BigInteger.valueOf(factorialInt(n));
            }
            if (n <= MAX_LONG) {
                return BigInteger.valueOf(factorialLong(n));
            }
            return factorialBig(n);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Cannot calculate factorial for negative number " + n);
            return BigInteger.ZERO;
        }
    }

    private static void validate(int n, int max) {
        if (n < 0 || n > max) {
            throw new IllegalArgumentException(String.format(
                    "Number %d is out of range [%d, %d]", n, 0, max));
        }
    }
}