package faang.school.godbless.async.and.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    static int sendAnalystics() {
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
        System.out.println("Method which waits 10 seconds run");
        Future<Integer> paymentFuture = executorService.submit(() -> collectPayment());
        System.out.println("Method which waits 1 seconds run");
        CompletableFuture<Integer> analyticsCompletableFuture = CompletableFuture.supplyAsync(() -> sendAnalystics(), executorService);

        try {
            System.out.println("Start of block try in doAll() method");
            int analyticsResult = analyticsCompletableFuture.get();
            System.out.println("Analytics result (which waits 1 second): " + analyticsResult);

            System.out.println("Now main thread will be blocked for 10 second");
            int paymentResult = paymentFuture.get();
            System.out.println("Payment result (which waits 10 second): " + paymentResult);
            executorService.shutdown();
            if (executorService.awaitTermination(12, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException | ExecutionException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        doAll();
    }
}
