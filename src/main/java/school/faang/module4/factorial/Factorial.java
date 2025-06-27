package school.faang.module4.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Factorial {
    private static final int MIN_FACTORIAL = 0;
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final BigInteger ZERO_FACTORIAL_VALUE = new BigInteger("1");

    public static void main(String[] args) throws InterruptedException {
        var numbers = List.of(1, 4, 8, 12, 15, 20, 25);
        var factorials = factorials(numbers);
        var threads = new Thread[factorials.size()];
        for (int i = 0; i < factorials.size(); i++) {
            var index = i;
            Runnable runnable = () -> {
                try {
                    BigInteger value = factorials.get(index).get();
                    int number = numbers.get(index);
                    System.out.printf("factorial of %d is %s\n", number, value);
                } catch (InterruptedException | ExecutionException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            };
            var thread = new Thread(runnable);
            thread.start();
            threads[i] = thread;
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .collect(ArrayList::new,
                        (factorials, n) -> factorials.add(CompletableFuture.supplyAsync(
                                () -> Factorial.factorialBig(n)
                        )),
                        ArrayList::addAll);
    }


    public static int factorialInt(int n) {
        validate(MAX_INT_FACTORIAL, n);
        return factorial(ZERO_FACTORIAL_VALUE, n).intValue();
    }

    public static long factorialLong(int n) {
        validate(MAX_LONG_FACTORIAL, n);
        return factorial(ZERO_FACTORIAL_VALUE, n).longValue();
    }

    public static BigInteger factorialBig(int n) {
        validate(Integer.MAX_VALUE, n);
        return factorial(ZERO_FACTORIAL_VALUE, n);
    }

    private static BigInteger factorial(BigInteger acc, int n) {
        if (n <= 1) {
            return acc;
        }
        return factorial(acc.multiply(new BigInteger(Integer.toString(n))), n - 1);
    }

    private static void validate(int availableMaxValue, int value) {
        if (value < MIN_FACTORIAL || availableMaxValue < value) {
            String message = String.format("value should be between %d and %d", MIN_FACTORIAL, availableMaxValue);
            throw new IllegalArgumentException(message);
        }
    }
}
