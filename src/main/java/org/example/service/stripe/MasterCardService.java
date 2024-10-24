package org.example.service.stripe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int COLLECT_PAYMENT_TIME = 10000;
    private static final int SEND_ANALYTIC_TIME = 1000;

    public void collectPayment() {
        boolean isCollected = process(COLLECT_PAYMENT_TIME, "payment");
        if (isCollected) {
            log.info("Payment was successful!");
        } else {
            log.info("Payment wasn't successful!");
        }
    }

    public String sendAnalytics() {
        boolean isSent = process(SEND_ANALYTIC_TIME, "sending analytics");
        if (isSent) {
            log.info("Analytics successfully sent!");
            return "Analytics successfully sent!";
        } else {
            log.info("Analytics successfully sent!");
            return "Analytics successfully sent!";
        }
    }

    private boolean process(int processTime, String operation) {
        try {
            Thread.sleep(processTime);
            return true;
        } catch (InterruptedException e) {
            log.warn("Interrupted during {}: {}", operation, e.getMessage());
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> paymentResult = executor.submit(this::collectPayment);
        CompletableFuture<?> sendAnalyticResult = CompletableFuture.supplyAsync(this::sendAnalytics);

        try {
            sendAnalyticResult.get();
            paymentResult.get();
        } catch (InterruptedException | ExecutionException e) {
            log.info(e.getMessage());
        }
        executor.shutdown();
    }
}
