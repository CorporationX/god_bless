package school.faang.godbless.bjs2_38331;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private Factorial() {
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers, ExecutorService pool) {
        List<CompletableFuture<BigInteger>> res = new ArrayList<>();
        numbers.forEach(number -> res.add(CompletableFuture.supplyAsync(() -> factorial(number), pool)));
        return res;
    }

    private static int factorialInt(int n) {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalStateException("The factorial of this number is too big for int");
        }
        int res = 1;
        for (int i = 2; i <= n; ++i) {
            res *= i;
        }
        return res;
    }

    private static long factorialLong(int n) {
        if (n <= MAX_INT_FACTORIAL || n > MAX_LONG_FACTORIAL) {
            throw new IllegalStateException("The factorial of this number is too small or too big for long");
        }
        long res = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; ++i) {
            res *= i;
        }
        return res;
    }

    private static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            throw new IllegalStateException("The factorial of this number is too small for BigInteger");
        }
        BigInteger res = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; ++i) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    private static BigInteger factorial(int n) {
        log.info("Thread {} is calculating {}!", Thread.currentThread().getName(), n);
        if (n <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(n));
        } else if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            return factorialBig(n);
        }
    }
}
