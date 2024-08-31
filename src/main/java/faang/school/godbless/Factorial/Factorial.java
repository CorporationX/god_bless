package faang.school.godbless.Factorial;


import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("n должно быть в диапазоне от 0 до " + MAX_INT_FACTORIAL);
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) {
        if (n <= MAX_INT_FACTORIAL || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("n должно быть в диапазоне от " + (MAX_INT_FACTORIAL + 1) + " до " + MAX_LONG_FACTORIAL);
        }
        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("n will to be more " + MAX_LONG_FACTORIAL);
        }
        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Асинхронное вычисление факториалов для списка чисел
    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        return numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> {
                    if (n <= MAX_INT_FACTORIAL) {
                        return BigInteger.valueOf(factorialInt(n));
                    } else if (n <= MAX_LONG_FACTORIAL) {
                        return BigInteger.valueOf(factorialLong(n));
                    } else {
                        return factorialBig(n);
                    }
                }, executorService))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(50, 100, 200, 300, 400, 10, 25, 10000);
        List<CompletableFuture<BigInteger>> result = factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);

        for (CompletableFuture<BigInteger> future : result) {
            new Thread(() -> {
                try {
                    // Ожидание завершения и вывод результата
                    BigInteger factorial = future.get();
                    System.out.println("Result: " + factorial);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // Увеличиваем счетчик по завершению задачи
                    counter.incrementAndGet();
                }
            }).start();
        }

        int awaitCounter = 0;
        // Ожидание выполнения всех задач
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }
}