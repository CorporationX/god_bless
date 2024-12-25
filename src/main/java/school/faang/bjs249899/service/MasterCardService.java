package school.faang.bjs249899.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService implements Runnable {
    public String collectPayment() {
        try {
            Thread.sleep(10000);
            return "Payment was successfully collected " + this;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String sendAnalytics() {
        try {
            Thread.sleep(1000);
            return "Analytics was sent " + this;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<String> paymentResult = threadPool.submit(this::collectPayment);
        CompletableFuture.supplyAsync(this::sendAnalytics)
                .thenAccept(System.out::println);
        try {
            System.out.println(paymentResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }
}
