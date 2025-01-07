package school.faang.bjs250404;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@UtilityClass
public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static List<CompletableFuture<BigInteger>> factorialFutures(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> CompletableFuture.supplyAsync(() -> calculateFactorial(number)))
                .toList();
    }

    public static int factorialInt(int number) throws IllegalArgumentException {
        if (number < 0 || number > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Factorial is out of int range");
        }

        return IntStream.rangeClosed(1, number)
                .reduce(1, (result, n) -> result * n);
    }

    public static long factorialLong(int number) throws IllegalArgumentException {
        if (number > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Factorial is out of long range");
        }

        int resultInt = factorialInt(MAX_INT_FACTORIAL);

        return LongStream.rangeClosed(MAX_INT_FACTORIAL + 1, number)
                .reduce(resultInt, (result, n) -> result * n);
    }

    public static BigInteger factorialBig(int number) {

        BigInteger resultLong = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));

        return IntStream.rangeClosed(MAX_LONG_FACTORIAL + 1, number)
                .mapToObj(BigInteger::valueOf)
                .reduce(resultLong, BigInteger::multiply);

    }

    private static BigInteger calculateFactorial(int number) {
        if (number <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(number));
        } else if (number <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(number));
        } else {
            return factorialBig(number);
        }
    }
}