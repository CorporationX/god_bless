package school.BJS2_38327;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {

    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 5, 12, 13, 18, 22, 25);

        factorials(numbers);
    }

    private static int factorialInt(int n) {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Некорректное число для factorialInt" + n);
        }
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialInt(n - 1);
        }
    }

    private static long factorialLong(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Некорректное число для factorialLong" + n);
        }
        long result = n;
        while (n > MAX_INT_FACTORIAL + 1) {
            result = (n - 1) * result;
            n--;
        }
        return result * factorialInt(MAX_INT_FACTORIAL);
    }

    private static BigInteger factorialBig(int n) {
        if (n < MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Некорректное число для расчета factorialBig" + n);
        }
        BigInteger result = new BigInteger(String.valueOf(n));
        while (n > MAX_LONG_FACTORIAL + 1) {
            result = result.multiply(new BigInteger(String.valueOf(n - 1)));
            n--;
        }
        BigInteger bigIntegerOfFactorialLong = new BigInteger(String.valueOf(factorialLong(MAX_LONG_FACTORIAL)));
        return bigIntegerOfFactorialLong.multiply(result);
    }

    private static void factorials(List<Integer> numbers) {
        List<CompletableFuture<Pair<Integer, BigInteger>>> futures = new ArrayList<>();
        numbers.forEach(number -> {
            futures.add(CompletableFuture.supplyAsync(() -> factorialСalculation(number)));
        });
        futures.forEach(future -> future.thenAccept(futureResult -> {
            System.out.printf("Факториал числа %d равен: %d \n", futureResult.getKey(), futureResult.getValue());
        }));
    }

    private static Pair<Integer, BigInteger> factorialСalculation(int number) {
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Введенное число меньше нуля:");
            } else if (number > 0 && number <= MAX_INT_FACTORIAL) {
                return new Pair<>(number, new BigInteger(String.valueOf(factorialInt(number))));
            } else if (number <= MAX_LONG_FACTORIAL) {
                return new Pair<>(number, new BigInteger(String.valueOf(factorialLong(number))));
            } else {
                return new Pair<>(number, factorialBig(number));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + number);
        }
        return null;
    }
}
