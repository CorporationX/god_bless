package faang.school.godbless.sprint4.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static ExecutorService executor;
    private static int factorialMaxInt;
    private static long factorialMaxLong;

    public static void main(String[] args) {
        factorialMaxInt = factorialInt(MAX_INT_FACTORIAL);
        factorialMaxLong = factorialLong(MAX_LONG_FACTORIAL);
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000, 1
        );
        executor = Executors.newFixedThreadPool(numbers.size());
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            int index = i;
            new Thread(
                    () -> {
                        CompletableFuture<BigInteger> future = result.get(index);
                        future.thenRun(() -> System.out.printf("Факториал числа %d - %d%n", numbers.get(index), future.join()))
                                .thenRun(counter::getAndIncrement);

                    }
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
        executor.shutdown();
    }

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    private static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException();
        }
        return LongStream.rangeClosed(MAX_INT_FACTORIAL + 1, n)
                .reduce(factorialMaxInt, (a, b) -> a * b);
    }

    private static BigInteger factorialBig(int n) {
        BigInteger factorialMax = BigInteger.valueOf(factorialMaxLong);
        return IntStream.rangeClosed(MAX_LONG_FACTORIAL + 1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(factorialMax, BigInteger::multiply);
    }

    private static BigInteger factorial(int n) {
        if (n <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(n));
        } else if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            return factorialBig(n);
        }
    }

    private static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture
                        .supplyAsync(() -> factorial(number), executor))
                .toList();
    }
}
