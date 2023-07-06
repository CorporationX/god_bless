package sprint5.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static List<CompletableFuture<BigInteger>> findFactorials(List<Integer> nums) {
        List<CompletableFuture<BigInteger>> futures = new ArrayList<>();
        for (int i : nums) {
            futures.add(
                    CompletableFuture.supplyAsync(() -> factorialBig(i))
            );
        }
        return futures;
    }

    private static int factorialInt(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorialInt(n - 1);
    }

    private static long factorialLong(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        return n * factorialLong(n - 1);
    }

    private static BigInteger factorialBig(int n) throws IllegalArgumentException, StackOverflowError {
        if (n <= 0) {
            throw new IllegalArgumentException("The number to be transmitted cannot be less than 1");
        }
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        return BigInteger.valueOf(n).multiply(factorialBig(n - 1));
    }
}
