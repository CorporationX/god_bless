package school.faang.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;
    private static final int FIXED_THREAD = 5;

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

    public static void calculate(List<Integer> numbers) {
        ExecutorService service = Executors.newFixedThreadPool(FIXED_THREAD);
        List<CompletableFuture<BigInteger>> listFuture = new ArrayList<>();
        for (Integer num : numbers) {
            CompletableFuture<BigInteger> future = CompletableFuture.supplyAsync(() -> factorialBig(num), service);
            listFuture.add(future);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(listFuture.toArray(new CompletableFuture[0]));

        CompletableFuture<List<BigInteger>> resultsFuture = allFutures.thenApply(v -> {
            List<BigInteger> results = new ArrayList<>();
            listFuture.forEach(future -> {
                try {
                    results.add(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    results.add(new BigInteger(String.valueOf(0)));
                }
            });
            return results;
        });

        resultsFuture.join();
        resultsFuture.thenAccept(result -> result.forEach(System.out::println));
        service.shutdown();
    }
}
