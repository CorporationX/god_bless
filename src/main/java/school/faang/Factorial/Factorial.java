package school.faang.Factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n){
        if(n > MAX_INT_FACTORIAL){
            throw new IllegalArgumentException("n is too large");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n){
        if(n > MAX_LONG_FACTORIAL){
            throw new IllegalArgumentException("n is too large");
        }
        long result;
        if (n > MAX_INT_FACTORIAL){
            result = factorialInt(MAX_INT_FACTORIAL);
            for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
                result *= i;
            }
        } else {
            result = factorialInt(n);
        }
        return result;
    }

    public static BigInteger factorialBigInteger(int n){
        BigInteger result;
        if(n > MAX_LONG_FACTORIAL){
            result = BigInteger.valueOf(factorialLong(MAX_LONG_FACTORIAL));
            for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        } else {
            result = BigInteger.valueOf(factorialLong(n));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers){
        return numbers.stream().map(e -> CompletableFuture.supplyAsync(() -> factorialBigInteger(e))).toList();
    }
}
