package faang.school.godbless.multithreading_async.task_1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int THREAD_COUNT = 4;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);
    private static final int COLLECTING_PAYMENT_DURATION = 10_000;
    private static final int SENDING_ANALYTICS_DURATION = 1_000;

    public void doAll() {
        final Future<Integer> collectedPaymentFuture = EXECUTOR.submit(MasterCardService::collectPayment);
        final CompletableFuture<Integer> sentAnalyticsFuture =
            CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, EXECUTOR);
        final int sentAnalytics = getFutureResult(sentAnalyticsFuture);
        log.info("Sent analytics: {}", sentAnalytics);
        final int collectedPayment = getFutureResult(collectedPaymentFuture);
        log.info("Collected payment: {}", collectedPayment);
    }

    public void shutdownExecutor() {
        EXECUTOR.shutdown();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(COLLECTING_PAYMENT_DURATION);
            return COLLECTING_PAYMENT_DURATION;
        } catch (InterruptedException e) {
            log.error("Interrupted during collecting payment", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during collecting payment", e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(SENDING_ANALYTICS_DURATION);
            return SENDING_ANALYTICS_DURATION;
        } catch (InterruptedException e) {
            log.error("Interrupted during sending analytics", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during collecting payment", e);
        }
    }

    private int getFutureResult(Future<Integer> integerFuture) {
        try {
            return integerFuture.get();
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while waiting for the collectedPaymentFuture result", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted while waiting for the " +
                "collectedPaymentFuture" + " result", e);
        } catch (ExecutionException e) {
            log.error("Exception occurred while trying to get the future result", e);
            throw new RuntimeException("Exception occurred while trying to get the future result", e);
        }
    }

}
