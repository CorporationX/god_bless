package faang.school.godbless.BJS213434;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics, executor
        );

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        analyticsFuture.thenAccept(analyticResult -> {
            System.out.println("Analytics sent with result: " + analyticResult);

            try {
                System.out.println("Payment result: " + paymentFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Error during payment collection", e);
            }
        }).join();

        System.out.println("All tasks finished");

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            } else {
                System.out.println("ExecutorService completed successfully");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error during complete ExecutorService", e);
        } finally {
            executor.shutdownNow();
        }
    }
}
