package ru.kraiush.BJS2_38023;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> paymentFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics(), executor);
        try {
            System.out.println("The payment is processed: " + paymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        Integer analyticsResult = analyticsFuture.join();
        System.out.println("Analytics was sent: " + analyticsResult);
        executor.shutdown();
    }
}
