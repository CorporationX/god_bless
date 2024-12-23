package school.faang.task_50219;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers,
                                                                 ExecutorService executorService) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>();
        for (int number : numbers) {
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(() -> {
                if (number < MAX_INT_FACTORIAL) {
                    return BigInteger.valueOf(factorialInt(number));
                } else if (number < MAX_LONG_FACTORIAL) {
                    return BigInteger.valueOf(factorialLong(number));
                } else {
                    return factorialBigInt(number);
                }
            }, executorService);
            results.add(result);
        }
        return results;
    }

    public static int factorialInt(int n) {
        if (n > MAX_INT_FACTORIAL || n < 0) {
            throw new IllegalArgumentException("Number cant be more than MAX_INT_FACTORIAL or less 0");
        }
        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) {
        if (n > MAX_LONG_FACTORIAL || n < 0) {
            throw new IllegalArgumentException("Number cant be more than MAX_LONG_FACTORIAL or less 0");
        }
        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i < n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBigInt(int n) {
        BigInteger result = null;
        if (n < MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
