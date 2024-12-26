package school.faang.bjs249899.service;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs249899.util.Constants;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService implements Runnable {
    public String collectPayment() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
            return "Payment was successfully collected " + this;
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public String sendAnalytics() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
            return "Analytics was sent " + this;
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return null;
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
            log.error(e.getMessage(), e);
        } finally {
            threadPool.shutdown();
        }
    }
}
