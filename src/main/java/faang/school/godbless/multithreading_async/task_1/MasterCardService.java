package faang.school.godbless.multithreading_async.task_1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int THREAD_COUNT = 4;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);

    public void doAll() {
        final Future<Integer> collectedPaymentFuture = EXECUTOR.submit(MasterCardService::collectPayment);
        final CompletableFuture<Integer> sentAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, EXECUTOR);
        final int sentAnalytics = getFutureResult(sentAnalyticsFuture);
        log.info("Sent analytics: {}", sentAnalytics);
        final int collectedPayment = getFutureResult(collectedPaymentFuture);
        log.info("Collected payment: {}", collectedPayment);
        EXECUTOR.shutdown();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int getFutureResult(Future<Integer> integerFuture) {
        try {
            return integerFuture.get();
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while waiting for the collectedPaymentFuture result", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted while waiting for the collectedPaymentFuture result", e);
        } catch (ExecutionException e) {
            log.error("Exception occurred while trying to get the future result", e);
            throw new RuntimeException("Exception occurred while trying to get the future result", e);
        }
    }
}
