package faang.school.godbless.bjs224831;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        try {
            int analyticsResult = analyticsFuture.join();
            System.out.println("Analytics result: " + analyticsResult);
            int paymentResult = paymentFuture.get();
            System.out.println("Payment result: " + paymentResult);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }

    }

    private int collectPayment() {
        try {
            Thread.sleep(3_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}