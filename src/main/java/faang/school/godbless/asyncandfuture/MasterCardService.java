package faang.school.godbless.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticsFuture = CompletableFuture
                    .supplyAsync(MasterCardService::sendAnalytics, executor);
            analyticsFuture.thenAccept(analyticsResult ->
                    log.info("Analytics analyticsResult: {}", analyticsResult)).join();
            int paymentResult = paymentFuture.get();
            log.info("Payment result: {}", paymentResult);
        } catch (InterruptedException e) {
            log.error("The operation was interrupted", e);
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log.error("Execution exception occurred", e);
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
            Thread.currentThread().interrupt();
        }
    }
}