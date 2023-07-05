package faang.school.godbless.GreatFactorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static void main(String[] args) {

        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = Factorial.factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            int j = i;
            new Thread(
                    () -> {
                        try {
                            System.out.println((j + 1) + " - " + result.get(j).get());
                            counter.addAndGet(1);
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

    public synchronized static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("n should be lesser then 13");
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public synchronized static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("n should be between 13 and 19");
        }
        long res = 1;
        if (n < 12) {
            res = factorialInt(n);
        } else {
            for (int i = 1; i <= n; i++) {
                res *= i;
            }
        }
        return res;
    }

    public synchronized static BigInteger factorialBig(int n) {
        BigInteger res = BigInteger.valueOf(1);
        if (n <= 19) {
            res = BigInteger.valueOf(factorialLong(n));
        } else {
            for (int i = 1; i <= n; i++) {
                res = res.multiply(BigInteger.valueOf(i));
            }
        }
        return res;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialBig(number)))
                .collect(Collectors.toList());
    }

    ;

}
