package school.faang.async.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final int ZERO_VALUE = 0;

    private static int factorialInt(int number) throws IllegalArgumentException {

        checkNumber(number, MAX_INT_FACTORIAL);
        return IntStream.rangeClosed(1, number)
                .reduce(1, (number1, number2) -> number1 * number2);
    }

    private static long factorialLong(int number) throws IllegalArgumentException {

        checkNumber(number, MAX_LONG_FACTORIAL);
        if (number <= MAX_INT_FACTORIAL) {
            return factorialInt(number);
        } else {
            return LongStream.rangeClosed(1, number)
                    .reduce(1, (number1, number2) -> number1 * number2);
        }
    }

    private static BigInteger factorialBigInt(int number) throws IllegalArgumentException {

        if (number <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(number));
        } else {
            return IntStream.rangeClosed(2, number)
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ONE, BigInteger::multiply);
        }
    }

    public static List<CompletableFuture<BigInteger>> calcFactorials(List<Integer> numbers) {
        return numbers.stream().map((number) ->
                CompletableFuture.supplyAsync(() -> factorialBigInt(number))
                ).toList();
    }

    private static void checkNumber(int number, int maxValue) throws IllegalArgumentException {
        if (number >= maxValue || number < ZERO_VALUE) {
            throw new IllegalArgumentException(String.format("Your number must be between 1 and %d",
                    maxValue));
        }
    }
}

