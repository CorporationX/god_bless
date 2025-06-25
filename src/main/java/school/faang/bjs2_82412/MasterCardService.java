package school.faang.bjs2_82412;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        log.info("Collecting payment...");
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            log.error("Thread interrupted while collecting payment", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        log.info("Sending analytics...");
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            log.error("Thread interrupted while sending analytics", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        int totalAwaitTime = 30;
        log.info("Starting all services...");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = analyticsFuture.join();
        log.info("Аналитика отправлена: {}", analyticsResult);

        try {
            Integer paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);
        } catch (InterruptedException e) {
            log.error("Thread interrupted while waiting for payment result", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log.error("Execution error while waiting for payment result", e);
            throw new RuntimeException(e);
        }

        executor.shutdown();
        try {
            log.info("Waiting for executor to terminate...");
            if (!executor.awaitTermination(totalAwaitTime, TimeUnit.SECONDS)) {
                log.error("Executor did not terminate in the specified time");
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted while waiting for executor to terminate", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("All services completed.");
    }
}
