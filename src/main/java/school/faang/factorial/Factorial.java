package school.faang.factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static void main(String[] args) {
        System.out.println(factorialBigInteger(24));
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialBigInteger(number)))
                .toList();
    }

    public static int factorialInt(int n) {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(n + " слишком велико для int");
        }
        return IntStream.rangeClosed(1, n)
                .reduce(1, (val1, val2) -> val1 * val2);
    }

    public static long factorialLong(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(n + " слишком велико для int");
        }
        if (n > MAX_INT_FACTORIAL) {
            CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(() -> factorialInt(MAX_INT_FACTORIAL));
            CompletableFuture<Long> longFuture = CompletableFuture.supplyAsync(
                    () -> LongStream.rangeClosed(MAX_INT_FACTORIAL + 1, n)
                            .reduce(1, (val1, val2) -> val1 * val2));
            return longFuture.thenCombine(intFuture,
                    (longRes, intRes) -> longRes * intRes).join();
        }
        return factorialInt(n);
    }

    public static BigInteger factorialBigInteger(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            CompletableFuture<Long> longFuture = CompletableFuture.supplyAsync(() -> factorialLong(MAX_LONG_FACTORIAL));
            CompletableFuture<BigInteger> bigIntegerFuture = CompletableFuture.supplyAsync(
                    () -> LongStream.rangeClosed(MAX_LONG_FACTORIAL + 1, n)
                            .mapToObj(BigInteger::valueOf)
                            .reduce(BigInteger.ONE, BigInteger::multiply));
            return bigIntegerFuture.thenCombine(longFuture,
                    (bigIntRes, longRes) -> bigIntRes.multiply(BigInteger.valueOf(longRes))).join();
        }
        return BigInteger.valueOf(factorialLong(n));
    }
}
