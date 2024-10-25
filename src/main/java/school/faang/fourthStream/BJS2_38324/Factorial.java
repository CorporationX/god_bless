package school.faang.fourthStream.BJS2_38324;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static Map<Integer, BigInteger> cash = new ConcurrentHashMap<>();

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());

        for (int number : numbers) {
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(() -> computeFactorial(number));
            results.add(result);
        }

        return results;
    }

    private static BigInteger computeFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(number + " недопустимое значение для данного метода");
        } else if (number <= MAX_INT_FACTORIAL) {
            return BigInteger.valueOf(factorialInt(number));
        } else if (number <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(number));
        } else {
            return factorialBigInt(number);
        }
    }

    private static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException(n + " недопустимое значение для данного метода");
        }

        if (cash.containsKey(n)) {
            return cash.get(n).intValue();
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            if (!cash.containsKey(i)) {
                result = result.multiply(BigInteger.valueOf(i));
                cash.putIfAbsent(i, result);
            } else {
                result = cash.get(i);
            }
        }

        return result.intValue();
    }

    private static long factorialLong(int n) {
        if (n < 0 || n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException(n + " недопустимое значение для данного метода");
        }

        if (n <= MAX_INT_FACTORIAL) {
            BigInteger result = BigInteger.valueOf(factorialInt(n));
            return result.longValue();
        }

        if (cash.containsKey(n)) {
            return cash.get(n).longValue();
        }

        BigInteger result = BigInteger.valueOf(factorialInt(MAX_INT_FACTORIAL));
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            if (!cash.containsKey(i)) {
                result = result.multiply(BigInteger.valueOf(i));
                cash.put(i, result);
            } else {
                result = cash.get(i);
            }
        }

        return result.longValue();
    }

    private static BigInteger factorialBigInt(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + " недопустимое значение");
        }

        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }

        if (cash.containsKey(n)) {
            return cash.get(n);
        }

        BigInteger result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            if (!cash.containsKey(i)) {
                result = result.multiply(BigInteger.valueOf(i));
                cash.put(i, result);
            } else {
                result = cash.get(i);
            }
        }

        return result;
    }
}
