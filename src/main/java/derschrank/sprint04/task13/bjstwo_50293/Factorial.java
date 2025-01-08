package derschrank.sprint04.task13.bjstwo_50293;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n < 0");
        } else if (n <= 1 ) {
            return n;
        } else if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(String.format("n > %d", MAX_INT_FACTORIAL));
        }

        return factorialInt(n - 1) * n;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(String.format("n > %d", MAX_LONG_FACTORIAL));
        }

        return factorialLong(n - 1) * n;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        return (factorialBig(n - 1)).multiply(BigInteger.valueOf(n));
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> futures = new ArrayList<>();
        for (Integer n : numbers) {
            futures.add(CompletableFuture.supplyAsync(() -> factorialBig(n)));
        }
        return futures;
    }

}
