package school.faang.sprint4.task_50282;

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

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> calculateFactorial(number)))
                .toList();
    }

    public static int factorialInt(int n) {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Can't count factorial greater than " + MAX_INT_FACTORIAL);
        }

        return IntStream.rangeClosed(1, n)
                .reduce(1, (res, element) -> res * element);
    }

    public static long factorialLong(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Can't count factorial greater than " + MAX_LONG_FACTORIAL);
        }

        int intResult = factorialInt(MAX_INT_FACTORIAL);
        return LongStream.rangeClosed(MAX_INT_FACTORIAL + 1, n)
                .reduce(intResult, (res, element) -> res * element);
    }

    public static BigInteger factorialBigInt(int n) {
        BigInteger longResult = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        return IntStream.rangeClosed(MAX_LONG_FACTORIAL + 1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(longResult, BigInteger::multiply);
    }

    private static BigInteger calculateFactorial(int number) {
        if (number <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(number));
        } else if (number <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(number));
        } else {
            return factorialBigInt(number);
        }
    }
}
