package school.faang.fourthStream.BJS2_38324;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final Map<Integer, BigInteger> CASH = new HashMap<>();

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());

        for (int number : numbers) {
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(() -> {
                if (number <= MAX_INT_FACTORIAL) {
                    return BigInteger.valueOf(factorialInt(number));
                } else if (number <= MAX_LONG_FACTORIAL) {
                    return BigInteger.valueOf(factorialLong(number));
                } else {
                    return factorialBigInt(number);
                }
            });
            results.add(result);
        }

        return results;
    }


    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Недопустимое значение для данноего метода");
        }

        if (CASH.containsKey(n)) {
            return CASH.get(n).intValue();
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            if (!CASH.containsKey(i)) {
                result = result.multiply(BigInteger.valueOf(i));
                CASH.put(i, result);
            } else {
                result = CASH.get(i);
            }
        }

        return result.intValue();
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Недопустимое значение для данноего метода");
        }

        if (CASH.containsKey(n)) {
            return CASH.get(n).longValue();
        }

        BigInteger result = BigInteger.valueOf(factorialInt(MAX_INT_FACTORIAL));
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            if (!CASH.containsKey(i)) {
                result = result.multiply(BigInteger.valueOf(i));
                CASH.put(i, result);
            } else {
                result = CASH.get(i);
            }
        }

        return result.longValue();
    }

    public static BigInteger factorialBigInt(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Недопустимое значение");
        }

        if (CASH.containsKey(n)) {
            return CASH.get(n);
        }

        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            if (!CASH.containsKey(i)) {
                result = result.multiply(BigInteger.valueOf(i));
                CASH.put(i, result);
            } else {
                result = CASH.get(i);
            }
        }

        return result;
    }
}
