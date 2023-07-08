package faang.school.godbless.kxnvg.factorial;

import lombok.SneakyThrows;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {

    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    @SneakyThrows
    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < result.size(); ++i) {
            final int a = i;
            new Thread(
                    () -> {
                        CompletableFuture<BigInteger> futureResult = result.get(a);
                        try {
                            System.out.println(futureResult.get());
                            counter.incrementAndGet();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
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
        List<CompletableFuture<BigInteger>> futures = new ArrayList<>();

        numbers.forEach(num -> {
            CompletableFuture<BigInteger> future = CompletableFuture.supplyAsync(() -> factorialBig(num));
            futures.add(future);
        });
        return futures;
    }

    public static  BigInteger factorialBig(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        } else {
            return BigInteger.valueOf(factorialLong(n));
        }
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        if (n <= MAX_LONG_FACTORIAL) {
            long result = factorialInt(MAX_INT_FACTORIAL);
            for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
                result *= i;
            }
            return result;
        } else {
            throw new IllegalArgumentException("Число не подхит в утсановленное значение");
        }
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n > 0 && n <= MAX_INT_FACTORIAL) {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        } else {
            throw new IllegalArgumentException("Число не подхит в утсановленное значение");
        }
    }
}
