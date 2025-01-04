package faang.school.godbless.FourthSprint.bjs2_50505;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        int result = 1;
        while (n > 0) {
            result *= n;
            n -= 1;
        }
        return result;
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        long result = factorialInt(MAX_INT_FACTORIAL);
        if (n <= MAX_INT_FACTORIAL || n > MAX_LONG_FACTORIAL) {
            result = factorialInt(n);
        }

        while (n > MAX_INT_FACTORIAL) {
            result *= n;
            n -= 1;
        }
        return result;
    }

    static BigInteger factorialBig(int n) {
        BigInteger result;
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        while (n > MAX_LONG_FACTORIAL) {
            result = result.multiply(BigInteger.valueOf(n));
            n -= 1;
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers){
        return numbers
                .stream()
                .map(n -> CompletableFuture.supplyAsync(() -> factorialBig(n)))
                .collect(Collectors.toList());
    }
}
