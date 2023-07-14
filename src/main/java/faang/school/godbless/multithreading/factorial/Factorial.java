package faang.school.godbless.multithreading.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);
        for (CompletableFuture<BigInteger> future : result) {
            new Thread(
                    () -> {
                        try {
                            System.out.println(future.get());
                        } catch (InterruptedException | ExecutionException e) {
                            log.error(e.getMessage());
                        }
                        counter.incrementAndGet();
                    }
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }

        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> factorialBig(n)))
                .toList();
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("n too big");
        }

        int factorial = 1;
        while (n > 1) {
            factorial *= n--;
        }
        return factorial;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("n too big");
        }
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        long factorial = factorialInt(MAX_INT_FACTORIAL);
        while (n > MAX_INT_FACTORIAL) {
            factorial *= n--;
        }
        return factorial;
    }

    public static BigInteger factorialBig(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger factorial = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        while (n > MAX_LONG_FACTORIAL) {
            factorial = factorial.multiply(BigInteger.valueOf(n--));
        }
        return factorial;
    }
}
