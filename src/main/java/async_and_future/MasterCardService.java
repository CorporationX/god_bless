package async_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> collectPaymentFuture = CompletableFuture.supplyAsync(MasterCardService::collectPayment, executorService);

        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sendAnalyticsFuture, collectPaymentFuture);

        combinedFuture.join();

        try {
            System.out.println("Result of sendAnalytics: " + sendAnalyticsFuture.get());
            System.out.println("Result of collectPayment: " + collectPaymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public static void main(String[] args) {
        doAll();
    }
}
