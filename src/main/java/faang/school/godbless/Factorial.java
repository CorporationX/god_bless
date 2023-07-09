package faang.school.godbless;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(50, 100, 200, 300, 400, 10, 25, 10000);
        List<CompletableFuture<BigInteger>> result = factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            int index = i;
            new Thread(() -> {
                CompletableFuture<BigInteger> future = result.get(index);
                BigInteger factorial = future.join();
                System.out.println("Factorial of digit " + numbers.get(index) + " equals " + factorial);
                counter.incrementAndGet();
            }).start();
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
                .collect(Collectors.toList());
    }


    static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Invalid input int");
        }

        if (n == 0) {
            return 1;
        }

        return n * factorialInt(n - 1);
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (n < MAX_INT_FACTORIAL + 1 ) {
            return factorialInt(n);
        } else if(n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Invalid input long");
        }


        if (n == 0) {
            return 1;
        }

        return (long) n * factorialLong(n - 1);
    }

    static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
