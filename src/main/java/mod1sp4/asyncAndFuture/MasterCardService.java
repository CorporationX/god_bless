package mod1sp4.asyncAndFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {

    private static final int THREAD_AMOUNT = 4;
    private static final int PAYMENT_TIMEOUT = 10_000;
    private static final int ANALYSIS_TIMEOUT = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_TIMEOUT);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("An error occurred while thread sleep", e);
            throw new IllegalStateException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ANALYSIS_TIMEOUT);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("An error occurred while thread sleep", e);
            throw new IllegalStateException(e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);
        Future<Integer> collectPaymentResult = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        try {
            System.out.println("Analytics result: " + analyticsResult.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("An error was occurred while waiting analytics result");
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Payment accept: " + collectPaymentResult.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("An error was occurred while waiting payment result");
            throw new RuntimeException(e);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error was occurred while shutting down threads");
            throw new RuntimeException(e);
        }
    }
}
