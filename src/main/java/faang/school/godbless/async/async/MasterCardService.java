package faang.school.godbless.async.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(
                this::sendAnalytics, executorService);

        Integer resultSendAnalytics = completableFuture.join();
        System.out.printf("Analytics received: %d -- %s\n", resultSendAnalytics, Thread.currentThread().getName());

        try {
            Integer resultCollectPayment = future.get();
            System.out.printf("Payment collected: %d -- %s\n", resultCollectPayment, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException("Getting result of collecting payment was interrupted");
        } catch (ExecutionException e) {
            throw new RuntimeException("Something went wrong during collecting payment");
        }

        executorService.shutdown();
    }

    private int collectPayment() {
        try {
            System.out.printf("Collecting payment -- %s\n", Thread.currentThread().getName());
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException("Collecting payment was interrupted");
        }
    }

    private int sendAnalytics() {
        try {
            System.out.printf("Sending analytics -- %s\n", Thread.currentThread().getName());
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            throw new RuntimeException("Sending analytics was interrupted");
        }
    }
}
