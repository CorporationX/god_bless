package school.faang.bjs2_61842;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            int analyticsResult = analyticsFuture.join();
            log.info("Analytics sent successfully: {}", analyticsResult);

            int paymentResult = future.get();
            log.info("Payment sent successfully: {}", paymentResult);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Operation was interrupted", e);
        } catch (ExecutionException e) {
            log.warn("Asynchronous task execution failed", e);
        } finally {
            executor.shutdown();
        }

    }

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
