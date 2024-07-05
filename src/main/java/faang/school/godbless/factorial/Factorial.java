package faang.school.godbless.factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Factorial {
    private static final int MIN_VALUE = 0;
    private static final int THREAD_NUM = 4;
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final int TIME_LIMIT_IN_SECONDS = 5;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> factorialResultList = new ArrayList<>();

        numbers.forEach(integer ->
                factorialResultList.add(
                        CompletableFuture.supplyAsync(() -> factorialBig(integer), executorService)
                )
        );

        return factorialResultList;
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < MIN_VALUE || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("The factorial of given value cannot be " +
                    "represented in int value or does not exist");
        }

        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("The factorial of given value cannot be " +
                    "represented in long value or does not exist");
        }

        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        long result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The factorial of given value does not exist");
        }

        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void closeFactorialCalculator() {
        executorService.shutdown();
        try {
            boolean result = executorService.awaitTermination(TIME_LIMIT_IN_SECONDS, TimeUnit.SECONDS);
            if (result) {
                log.info("All tasks were executed on time");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Executor service was interrupted during awaiting termination");
        }
    }
}