package school.faang.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            if (n > MAX_INT_FACTORIAL) {
                throw new IllegalArgumentException();
            }
            result *= i;
        }
        return result;
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        long result;

        if (n > MAX_INT_FACTORIAL) {
            result = factorialInt(MAX_INT_FACTORIAL);
            for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
                if (n > MAX_LONG_FACTORIAL) {
                    throw new IllegalArgumentException();
                }
                result *= i;
            }
        } else {
            result = factorialInt(n);
        }

        return result;
    }

    static BigInteger factorialBig(int n) {
        BigInteger result;
        if (n > MAX_LONG_FACTORIAL) {
            result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        } else {
            result = BigInteger.valueOf(factorialLong(n));
        }
        return result;
    }

    public List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> futures = new ArrayList<>();
        for (int number : numbers) {
            futures.add(CompletableFuture.supplyAsync(() -> factorialBig(number)));
        }
        return futures;
    }
}
