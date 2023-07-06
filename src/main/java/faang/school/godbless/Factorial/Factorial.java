package faang.school.godbless.Factorial;

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
            int finalI = i;
            new Thread(
                    () -> {
                        try {
                            System.out.println("Факториал под индексом " + finalI + " равен " + result.get(finalI).get());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
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

    static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Число слишком большое");
        }

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL & n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Число не попадает в диапазон работы метода");
        }

        long result = factorialInt(MAX_INT_FACTORIAL);

        for (long i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    static BigInteger factorialBig(int n) {

        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));

        for (long i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> futureFactorials = new ArrayList<>();

        for (Integer number : numbers) {
            CompletableFuture<BigInteger> futureFactorial = CompletableFuture.supplyAsync(() -> {
                if (number <= MAX_INT_FACTORIAL) {
                    return BigInteger.valueOf(factorialInt(number));
                } else if (number > MAX_INT_FACTORIAL & number <= MAX_LONG_FACTORIAL) {
                    return BigInteger.valueOf(factorialLong(number));
                }
                return factorialBig(number);
            });
            futureFactorials.add(futureFactorial);
        }

        return futureFactorials;
    }
}