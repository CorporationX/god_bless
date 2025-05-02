package school.faang.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final int FIXED_THREAD = 2;

    private static int factorialInt(int n) {
        if (n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Erooorrr");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static long factorialLong(int n) {

        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Erooorrr");
        }

        if (n < MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static BigInteger factorialBig(int n) {
        if (n < MAX_INT_FACTORIAL) {
            return new BigInteger(String.valueOf(factorialInt(n)));
        }
        if (n < MAX_LONG_FACTORIAL) {
            return new BigInteger(String.valueOf(factorialLong(n)));
        }
        BigInteger result = new BigInteger(String.valueOf(1));
        for (int i = 2; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }

    public static List<CompletableFuture<BigInteger>> calculate(List<Integer> numbers) {
        ExecutorService service = Executors.newFixedThreadPool(FIXED_THREAD);
        List<CompletableFuture<BigInteger>> listFuture = new ArrayList<>();
        for (Integer num : numbers) {
            CompletableFuture<BigInteger> future = CompletableFuture.supplyAsync(() -> factorialBig(num), service);
            listFuture.add(future);
        }
        service.shutdown();
        return listFuture;
    }
}
