package org.example.service.stripe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MasterCardService {
    private static final int COLLECT_PAYMENT_TIME = 1000;
    private static final int SEND_ANALYTIC_TIME = 10000;

    public String collectPayment() {
        boolean isCollected = process(COLLECT_PAYMENT_TIME, "payment");
        if (isCollected) {
            log.info("Payment was successful!");
            return "Payment was successful!";
        } else {
            log.info("Payment wasn't successful!");
            return "Payment wasn't successful!";
        }
    }

    public String sendAnalytics() {
        boolean isSent = process(SEND_ANALYTIC_TIME, "sending analytics");
        if (isSent) {
            log.info("Analytics successfully sent!");
            return "Analytics successfully sent!";
        } else {
            log.info("Analytics wasn't sent!");
            return "Analytics wasn't sent!";
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
        ExecutorService executorSendAnalytic = Executors.newFixedThreadPool(1);

        CompletableFuture<String> sendAnalyticResult = CompletableFuture.supplyAsync(this::sendAnalytics, executorSendAnalytic);
        sendAnalyticResult.join();

        CompletableFuture<String> paymentResult = CompletableFuture.supplyAsync(this::collectPayment, executorSendAnalytic);
        paymentResult.join();

        executorSendAnalytic.shutdown();
    }
}
