package school.faang.bjs2_74743;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int THREADS_COUNT = 2;
    private static final int AWAITING_TIME = 3;

    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while collecting payments", e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while sending analytics", e);
        }
    }

    public void doAll() {
        Future<Integer> paymentFuture = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        log.info("Analytics sent: {}", analyticFuture.join());
        try {
            log.info("Payment completed: {}", paymentFuture.get(AWAITING_TIME, TimeUnit.MINUTES));
        } catch (ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Error while executing payment collecting", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while collecting payment", e);
        } catch (TimeoutException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Timeout: payment collection did not complete within the allotted time", e);
        }
        shutdownExecutorService();
    }

    private void shutdownExecutorService() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                log.warn("Timeout: collecting payment and sending analytics were not completed within the allotted " +
                        "time");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while waiting for completion collecting " +
                    "payment and sending analytics", e);
        }
    }
}
