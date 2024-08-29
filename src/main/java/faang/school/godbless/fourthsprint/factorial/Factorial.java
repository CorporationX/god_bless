package faang.school.godbless.fourthsprint.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static long factorialLong(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static List<CompletableFuture<Map.Entry<Integer, BigInteger>>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> Map.entry(n, factorialBig(n))))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of( 50, 100, 200, 300, 400, 10, 25, 1000);
        List<CompletableFuture<Map.Entry<Integer, BigInteger>>> result = factorials(numbers);

        result.forEach(future -> future.thenAccept(entry -> System.out.println("Factorial of " +
                entry.getKey() + ": " + entry.getValue())));

        CompletableFuture.allOf(result.toArray(new CompletableFuture[0])).join();

        System.out.println("Awaited all asynchronous tasks.");
    }
}
