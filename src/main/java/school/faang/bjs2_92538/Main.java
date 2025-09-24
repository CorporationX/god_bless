package school.faang.bjs2_92538;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        doAll();
    }

    static void doAll() {
        CompletableFuture.supplyAsync(() -> MasterCardService.sendAnalytics(), executor)
                .thenAccept((result) -> System.out.println(result));
        Future<Integer> paymentResult = executor.submit(() -> MasterCardService.collectPayment());

        try {
            System.out.println(paymentResult.get());
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}