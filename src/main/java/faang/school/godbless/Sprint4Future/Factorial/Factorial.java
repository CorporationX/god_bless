package faang.school.godbless.Sprint4Future.Factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            CompletableFuture<BigInteger> factorial = result.get(i);
            new Thread(
                    () -> {
                        try {
                            System.out.println(factorial.get());
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

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n > 0 && n <= MAX_INT_FACTORIAL){
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL && n <= MAX_LONG_FACTORIAL){
            long result = factorialInt(MAX_INT_FACTORIAL);
            for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        } else {
            return factorialInt(n);
        }
    }

    private static BigInteger factorialBig(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++)
                result = result.multiply(BigInteger.valueOf(i));
            return result;
        } else {
            return BigInteger.valueOf(factorialLong(n));
        }
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> factorials = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int finalI = numbers.get(i);
            CompletableFuture<BigInteger> futureFactorials = CompletableFuture
                    .supplyAsync(() -> factorialBig(finalI));
            factorials.add(futureFactorials);
        }
        return factorials;
    }
}
