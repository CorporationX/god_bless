package school.faang.bjs250332;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

public class Factorial {

    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) {
        if (n > MAX_INT_FACTORIAL || n < 0) {
            throw new IllegalArgumentException("max range preceded or number is negative");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) {
        if (n > MAX_LONG_FACTORIAL || n < MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("number must be between 12 and 19");
        }
        long result = 1;
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> factorialInt(12));
        for (int i = MAX_INT_FACTORIAL + 1; i <= n; i++) {
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result *= i;
        }
        return result * future.join();
    }

    public static BigInteger factorialBig(int n) {
        if (n < MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("max range preceded");
        }
        BigInteger result = new BigInteger("1");
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> factorialLong(19));
        for (int i = MAX_LONG_FACTORIAL + 1; i <= n; i++) {
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result.multiply(BigInteger.valueOf(future.join()));
    }

}
