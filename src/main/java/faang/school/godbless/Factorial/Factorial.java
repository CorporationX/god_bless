package faang.school.godbless.Factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("factorial of " + n + " is bigger than int limit");
        } else if (n < 0) {
            throw new IllegalArgumentException("factorial of " + n + " can't be calculated");
        }

        int res = 1;
        int count = 2;
        while (count <= n) {
            res *= count;
            count++;
        }
        return res;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("factorial of " + n + " is bigger than long limit");
        }

        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        long res = factorialInt(MAX_INT_FACTORIAL);
        int count = MAX_INT_FACTORIAL + 1;
        while (count <= n) {
            res *= count;
            count++;
        }
        return res;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger res = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        int count = MAX_LONG_FACTORIAL + 1;
        while (count <= n) {
            res = res.multiply(BigInteger.valueOf(count));
            count++;
        }
        return res;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int num : numbers) {
            results.add(
                    CompletableFuture
                            .supplyAsync(() -> factorialBig(num))
                            .handle((out, exc) -> {
                                if (out == null) {
                                    log.error(exc.getMessage());
                                    return null;
                                } else {
                                    return out;
                                }
                            })
            );
        }
        return results;
    }
}
