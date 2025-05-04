package school.faang.stream4.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    private static int twelveFactorial;
    private static long nineteenFactorial;

    private static int factorialInt(int n) throws IllegalArgumentException {
        if (n <= 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(
                    String.format("argument %d is not in allowed int range", n)
            );
        }

        if (n == MAX_INT_FACTORIAL && twelveFactorial != 0) {
            return twelveFactorial;
        }

        int factorial = IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);

        if (n == MAX_INT_FACTORIAL) {
            twelveFactorial = factorial;
        }

        return factorial;
    }

    private static long factorialLong(int n) throws IllegalArgumentException {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(
                    String.format("argument %d is not in allowed long range", n)
            );
        }

        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        if (n == MAX_LONG_FACTORIAL && nineteenFactorial != 0) {
            return nineteenFactorial;
        }

        long factorial = LongStream.rangeClosed(MAX_INT_FACTORIAL + 1, n)
                .reduce(factorialInt(MAX_INT_FACTORIAL), (a, b) -> a * b);

        if (n == MAX_LONG_FACTORIAL) {
            nineteenFactorial = factorial;
        }

        return factorial;
    }

    private static BigInteger factorialBig(int n) throws IllegalArgumentException {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        return IntStream.range(MAX_LONG_FACTORIAL + 1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL)), BigInteger::multiply);
    }

    public static List<CompletableFuture<BigInteger>> calculateListFactorials(List<Integer> base) {

        return base.stream()
                .map(integer ->
                        CompletableFuture.supplyAsync(() -> factorialBig(integer), EXECUTOR_SERVICE)
                )
                .toList();
    }
}
