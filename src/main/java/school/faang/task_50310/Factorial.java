package school.faang.task_50310;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {
    private static final Logger logger = LoggerFactory.getLogger(Factorial.class);

    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            logger.error("Value n = {} out of range for int factorial [0..{}]", n, MAX_INT_FACTORIAL);
            throw new IllegalArgumentException("Value n = " + n + " out of range for int factorial [0.." + MAX_INT_FACTORIAL + "]");
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private static long factorialLong(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        if (n > MAX_LONG_FACTORIAL) {
            logger.error("Value n = {} out of range for long factorial [0..{}]", n, MAX_LONG_FACTORIAL);
            throw new IllegalArgumentException("Value n = " + n + " out of range for long factorial [0.." + MAX_LONG_FACTORIAL + "]");
        }

        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static BigInteger factorial(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            return factorialBig(n);
        } else if (n > MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            return BigInteger.valueOf(factorialInt(n));
        }
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> nums) {
        return nums.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorial(number))
                        .exceptionally(ex -> {
                            logger.error("Error calculating factorial for number: {}", number, ex);
                            return BigInteger.ZERO;
                        }))
                .toList();
    }
}
