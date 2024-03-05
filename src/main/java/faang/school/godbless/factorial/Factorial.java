package faang.school.godbless.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static long factorialLong(int n) {
        long factorial = 1;
        if (n < MAX_LONG_FACTORIAL && n > MAX_INT_FACTORIAL) {
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        } else {
            return factorialInt(n);
        }
    }

    static BigInteger factorialBig(int n) {
        BigInteger factorial = BigInteger.valueOf(1);
        if (n > MAX_LONG_FACTORIAL) {
            for (int i = 2; i <= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial;
        } else {
            return BigInteger.valueOf(factorialLong(n));
        }
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map((number -> CompletableFuture.supplyAsync(() -> factorialBig(number))))
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000, 13
        );
        List<CompletableFuture<BigInteger>> results = factorials(numbers);
        CompletableFuture.allOf(results.toArray(CompletableFuture[]::new)).join();
        results.forEach(result -> {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }
}