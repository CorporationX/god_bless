package school.faang.sprint_4.task_50454;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int n) {
        return IntStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }

    private static long factorialLong(int n) {
        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= n;
        }
        return result;
    }

    private static BigInteger factorialBig(int n) {
        BigInteger result;
        result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());

        for (int number : numbers) {
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(() -> {
                if (number < 0) {
                    throw new IllegalArgumentException("The number cannot be less than zero");
                } else if (number <= MAX_INT_FACTORIAL) {
                    return BigInteger.valueOf(factorialInt(number));
                } else if (number <= MAX_LONG_FACTORIAL) {
                    return BigInteger.valueOf(factorialLong(number));
                } else {
                    return factorialBig(number);
                }
            });
            results.add(result);
        }
        return results;
    }
}
