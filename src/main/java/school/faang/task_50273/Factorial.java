package school.faang.task_50273;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Your number must be greater than "
                    + "0 and less than " + MAX_INT_FACTORIAL);
        }
        int factorial = n;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static long factorialLong(int n) {
        if (n >= 0 && n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        } else if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Your number must be greater than "
                    + "0 and less than " + MAX_LONG_FACTORIAL);
        }
        long factorial = n;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static BigInteger factorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Your number must be greater than 0");
        } else if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger factorial = BigInteger.valueOf(n);
        for (int i = 2; i < n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream().map(number -> {
            return CompletableFuture.supplyAsync(() -> {
                BigInteger factorial = factorialBig(number);
                log.info("Factorial of {}: {}", number, factorial);
                return factorial;
            });
        }).toList();
    }
}
