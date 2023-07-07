package faang.school.godbless.factorial;

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

        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < result.size(); ++i) {
            int finalI = i;

            new Thread(
                    () -> {
                        try {
                            result.get(finalI).get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }

                        counter.addAndGet(1);
                    }
            ).start();
        }

        int awaitCounter = 0;

        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }

        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }

    synchronized static int factorialInt(int n) throws IllegalArgumentException {
        if (n > MAX_INT_FACTORIAL || n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int counter = 1;
        int result = 1;

        while (counter <= n) {
            int buffer = counter;

            counter++;

            result = result * buffer;
        }

        return result;
    }

    synchronized static long factorialLong(int n) throws IllegalArgumentException {
        if (n < MAX_INT_FACTORIAL + 1)  {
            return factorialInt(n);
        } else if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException();
        } else {
            int counter = 1;
            long result = 1;

            while (counter <= n) {
                int buffer = counter;

                counter++;

                result = result * buffer;
            }

            return result;
        }
    }

     synchronized static BigInteger factorialBig(int n) {
        if (n < MAX_LONG_FACTORIAL + 1) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            int counter = 1;
            long result = 1;

            while (counter <= n) {
                int buffer = counter;

                counter++;

                result = result * buffer;
            }

            return BigInteger.valueOf(result);
        }
    }

    static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> futureList = new ArrayList<>(numbers.size());

        for (Integer number : numbers) {
            futureList.add(CompletableFuture.supplyAsync(
                    () -> factorialBig(number)
            ));
        }

        return futureList;
    }
}
