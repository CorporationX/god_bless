package school.faang.task50240;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    private BigInteger factorialNumberRange(int number) {
        if (number <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(number));
        } else if (number <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(number));
        }

        return factorialBigInteger(number);
    }

    private static void checkNumberRange(int n, int range) {
        if (n > range) {
            throw new IllegalArgumentException(String.format("Число должно быть меньше %d", range));
        }
    }

    private static BigInteger range(int start, int end) {

        return IntStream.rangeClosed(start, end)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static int factorialInt(int n) throws IllegalArgumentException {
        checkNumberRange(n, MAX_INT_FACTORIAL);

        return range(1, n).intValue();
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        checkNumberRange(n, MAX_LONG_FACTORIAL);

        return factorialInt(Math.min(n, MAX_INT_FACTORIAL))
                * range(MAX_INT_FACTORIAL + 1, Math.min(n, MAX_LONG_FACTORIAL)).longValue();
    }

    public static BigInteger factorialBigInteger(int n) {
        return BigInteger.valueOf(factorialLong(Math.min(n, MAX_LONG_FACTORIAL)))
                .multiply(range(MAX_LONG_FACTORIAL + 1, n));
    }

    public List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        Objects.requireNonNull(numbers);

        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> factorialNumberRange(number))
                        .thenApply(result -> {
                            log.info("Факториал числа {} равен {}", number, result);
                            return result;
                        }))
                .toList();
    }
}
