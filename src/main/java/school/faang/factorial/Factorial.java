package school.faang.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MIN_FACTORIAL = 0;
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int calculateIntFactorial(int n) {
        if (n < MIN_FACTORIAL || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("The input number must be between 0 and 12");
        }
        int result = 1;
        for (int i = MIN_FACTORIAL + 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static long calculateLongFactorial(int n) {
        if (n < MIN_FACTORIAL || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("The input number must be between 0 and 19");
        }
        long result = calculateIntFactorial(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static BigInteger calculateBigIntFactorial(int n) {
        if (n < MIN_FACTORIAL) {
            throw new IllegalArgumentException("The input number must be greater than 0");
        }
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(calculateLongFactorial(n));
        } else {
            BigInteger result = BigInteger.valueOf(calculateLongFactorial(MAX_LONG_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }

    public static List<CompletableFuture<BigInteger>> calculateFactorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> {
                    if (number <= MAX_INT_FACTORIAL) {
                        return BigInteger.valueOf(calculateIntFactorial(number));
                    } else if (number <= MAX_LONG_FACTORIAL) {
                        return BigInteger.valueOf(calculateLongFactorial(number));
                    } else {
                        return calculateBigIntFactorial(number);
                    }
                })).toList();
    }
}
