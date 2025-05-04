package school.faang.stream4.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        List<Integer> base = List.of(9, 10, 14, 17, 18, 19, 20, 25, 29, 38, 55, 99, 300);

        List<CompletableFuture<BigInteger>> completableFutures = Factorial.calculateListFactorials(base);

        ExecutorService service = Factorial.EXECUTOR_SERVICE;
        CompletableFuture[] allOf = completableFutures.stream()
                .map(cf -> cf.thenAcceptAsync(System.out::println, service))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(allOf).join();

        service.shutdown();
        try {
            if (!service.awaitTermination(30L, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }
}
