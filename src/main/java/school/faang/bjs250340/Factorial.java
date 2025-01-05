package school.faang.bjs250340;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_INT_RESULT = 479001600;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final long MAX_LONG_RESULT = 121645100408832000L;

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("n > MAX_INT_FACTORIAL");
        }

        if (n == 1) {
            return 1;
        }

        return n * factorialInt(n - 1);
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("n > MAX_LONG_FACTORIAL");
        }

        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        long result = MAX_INT_RESULT;
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }

    public static BigInteger factorialBig(int n) {
        log.info("factorialBig({})", n);
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger result = BigInteger.valueOf(MAX_LONG_RESULT);
        for (int i = MAX_LONG_FACTORIAL; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialBig(number)))
                .toList();
    }
}
