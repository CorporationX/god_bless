package school.faang.m1s4.bjs2_38323_factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final Map<Integer, BigInteger> COMPUTED_FACTORIALS = new ConcurrentHashMap<>();

    public BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input: integer is negative");
        } else if (n <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(n));
        } else if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            return factorialBig(n);
        }
    }

    public List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers, ExecutorService service) {
        return numbers.stream()
                .map(number ->
                        CompletableFuture.supplyAsync(() ->
                                factorial(number), service))
                .toList();
    }

    public List<CompletableFuture<BigInteger>> factorialsOptimyzed(List<Integer> numbers, ExecutorService service) {
        return numbers.stream()
                .map(number ->
                        CompletableFuture.supplyAsync(() ->
                                factorialOptimized(number), service))
                .toList();
    }

    private BigInteger factorialOptimized(int n) {
        if (COMPUTED_FACTORIALS.containsKey(n)) {
            return COMPUTED_FACTORIALS.get(n);
        }

        BigInteger result;
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input: integer is negative");
        } else if (n <= 12) {
            result = BigInteger.valueOf(factorialInt(n));
        } else if (n <= 19) {
            result = BigInteger.valueOf(factorialLong(n));
        } else {
            result = factorialBig(n);
        }
        COMPUTED_FACTORIALS.put(n, result);
        return result;
    }

    private int factorialInt(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialInt(n - 1);
        }
    }

    private long factorialLong(int n) {
        if (n == 12) {
            return factorialInt(n);
        } else {
            return n * factorialLong(n - 1);
        }
    }

    private BigInteger factorialBig(int n) {
        if (n == 19) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            return factorialBig(n - 1).multiply(BigInteger.valueOf(n));
        }
    }
}
