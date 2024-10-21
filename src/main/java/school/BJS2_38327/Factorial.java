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

        List<Integer> numbers = Arrays.asList(5, 2, 7, 2, 1, 8, 21);

        List<CompletableFuture<BigInteger>> itog = factorials(numbers);

        itog.stream().forEach(number -> System.out.println(number.join()));

    }

    private static int factorialInt(int n) {
        if (n > 0 && n <= MAX_INT_FACTORIAL) {
            if (n <= 1) {
                return 1;
            } else {
                return n * factorialInt(n - 1);
            }
        } else {
            throw new IllegalArgumentException("Число больше MAX_INT_FACTORIAL");
        }
    }

    private static long factorialLong(int n) {
        if (n > MAX_INT_FACTORIAL + 1 && n <= MAX_LONG_FACTORIAL) {
            int result = n;
            while (n > MAX_INT_FACTORIAL + 1) {
                result = (n - 1) * result;
                n--;
            }
            return (long) result * factorialInt(MAX_INT_FACTORIAL);
        } else {
            throw new IllegalArgumentException("Число больше MAX_LONG_FACTORIAL");
        }
    }

    private static BigInteger factorialBig(int n) {
        if (n > MAX_LONG_FACTORIAL) {
            int result = n;
            while (n > MAX_LONG_FACTORIAL + 1) {
                result = (n - 1) * result;
                n--;
            }
            BigInteger int1 = new BigInteger(String.valueOf(factorialLong(MAX_LONG_FACTORIAL)));
            BigInteger int2 = new BigInteger(String.valueOf(result));
            return int1.multiply(int2);
        }
        return null;
    }

    private static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> listOfBigInteger = new ArrayList<>();
        numbers.stream().forEach(number -> {
            CompletableFuture<BigInteger> numberInFactorials = CompletableFuture.supplyAsync(() -> {
                if (number <= MAX_INT_FACTORIAL) {
                    return new BigInteger(String.valueOf(factorialInt(number)));
                } else if (number > MAX_INT_FACTORIAL + 1 && number <= MAX_LONG_FACTORIAL) {
                    return new BigInteger(String.valueOf(factorialLong(number)));
                } else return factorialBig(number);
            });
            listOfBigInteger.add(numberInFactorials);
        });
        return listOfBigInteger;
    }
}
