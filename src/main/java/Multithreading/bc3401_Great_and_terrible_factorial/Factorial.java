package Multithreading.bc3401_Great_and_terrible_factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        long factorial = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static BigInteger factorialBig(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(n));
        }
        BigInteger factorial = new BigInteger(String.valueOf(factorialLong(MAX_LONG_FACTORIAL)));

        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture
                        .supplyAsync(() -> factorialBig(number))
                ).toList();
    }


}

