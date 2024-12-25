package school.faang.sprint_4.task_50260;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> futureList = new ArrayList<>();

        numbers.forEach((number) -> {
            CompletableFuture<BigInteger> futureResult = CompletableFuture.supplyAsync(() -> {
                if (number > MAX_LONG_FACTORIAL) {
                    return factorialBig(number);
                } else if (number > MAX_INT_FACTORIAL) {
                    return BigInteger.valueOf(factorialLong(number));
                } else {
                    return BigInteger.valueOf(factorialInt(number));
                }
            });
            futureList.add(futureResult);
        });
        return futureList;
    }

    private static int factorialInt(int number) {
        if (number < 0 || number > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Значение не может быть меньше 0 и больше " + MAX_INT_FACTORIAL);
        }
        int result = 1;
        for (int index = 2; index <= number; index++) {
            result *= index;
        }
        return result;
    }

    private static long factorialLong(int number) {
        if (number < 0 || number > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Значение не может быть меньше 0 и больше " + MAX_LONG_FACTORIAL);
        }
        long result = factorialInt(MAX_INT_FACTORIAL);
        for (int index = MAX_INT_FACTORIAL + 1; index <= number; index++) {
            result *= index;
        }
        return result;
    }

    private static BigInteger factorialBig(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Значение не может быть меньше 0");
        }
        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int index = MAX_LONG_FACTORIAL + 1; index <= number; index++) {
            result = result.multiply(BigInteger.valueOf(index));
        }
        return result;
    }
}
