package school.faang.sprint_4.task_50250;

import lombok.SneakyThrows;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Number greater then int border");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static long factorialLong(int n) {
        if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Number greater then long border");
        }
        if (n < MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @SneakyThrows
    private static BigInteger factorialBig(int n) {
        if (n < MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers
                .stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialBig(number)))
                .toList();
    }
}
