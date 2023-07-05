package Sprint_4_1_Task12;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        if (0 < n && n <= MAX_INT_FACTORIAL) {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (MAX_INT_FACTORIAL < n && n <= MAX_LONG_FACTORIAL) {
            long result = factorialInt(MAX_INT_FACTORIAL);
            for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        } else {
           throw new IllegalArgumentException();
        }
    }

    static BigInteger factorialBig(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL+1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        } else {
            return BigInteger.valueOf(Factorial.factorialLong(n));
        }
    }

    static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); ++i) {
            int finalI = i;
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(
                    () -> factorialBig(numbers.get(finalI))
            );
            results.add(result);
        }

        return results;
    }
    public static void main(String[] args) {
        System.out.println(factorialBig(25));

        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        var counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            new Thread(
//                    counter::incrementAndGet
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }
}

