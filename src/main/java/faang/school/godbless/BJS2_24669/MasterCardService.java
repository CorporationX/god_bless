package faang.school.godbless.BJS2_24669;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            int analyticsResult = analyticsFuture.get();
            System.out.printf("Analytics result: %d\n", analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.printf("Payment result: %d\n ", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
            try {
                executor.awaitTermination(1, TimeUnit.HOURS);
            } catch (InterruptedException e) {
                System.out.printf("Error: %s\n", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
