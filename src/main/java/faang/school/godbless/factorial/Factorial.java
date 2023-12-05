package faang.school.godbless.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Argument should be from 0 to " + MAX_INT_FACTORIAL);
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (n <0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Argument should be from 0 to " + MAX_LONG_FACTORIAL);
        }
        long factorial = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        }
        BigInteger factorial = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(() -> factorialBig(currentNumber));
            results.add(result);
        }
        return results;
    }
}
