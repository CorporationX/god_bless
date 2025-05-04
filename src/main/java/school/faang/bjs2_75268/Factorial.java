package school.faang.bjs2_75268;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Слишком большое число");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Слишком большое число");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static BigInteger factorialBig(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(a -> CompletableFuture.supplyAsync(() -> {
                    if (a <= MAX_INT_FACTORIAL) {
                        return BigInteger.valueOf(factorialInt(a));
                    } else if (a <= MAX_LONG_FACTORIAL) {
                        return BigInteger.valueOf(factorialLong(a));
                    } else {
                        return factorialBig(a);
                    }
                }))
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(0,1,4, 13, 18, 20);
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        result.forEach(a -> System.out.println(a.join()));
    }
}
