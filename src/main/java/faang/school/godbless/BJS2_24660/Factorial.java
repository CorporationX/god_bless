package faang.school.godbless.BJS2_24660;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static ExecutorService executors = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 15, 25, 10000
        );

        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        result.forEach(CompletableFuture::join);
        executors.shutdown();
        try {
            if (!executors.awaitTermination(10, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Smth happened: {}", e.getMessage());
        }

        result.forEach(res -> System.out.println(res.join()));
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Number is too big for int");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Number is too big for long");
        }
        if (n > MAX_INT_FACTORIAL) {
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result = result * i;
            }
            return result;
        }

        return factorialInt(n);
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            BigInteger result = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }

            return result;
        }

    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(factNumber -> CompletableFuture
                        .supplyAsync(() -> factorialBig(factNumber), executors))
                .toList();
    }
}
