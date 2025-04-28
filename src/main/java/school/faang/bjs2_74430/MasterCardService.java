package school.faang.bjs2_74430;

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
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Future<Integer> collectPayment() {
        final int result = 5_000;
        return executor.submit(() -> {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return result;
        });
    }

    public Future<Integer> sendAnalytics() {
        final int result = 17_000;
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ONE_SECOND_IN_MS);
            } catch (InterruptedException e) {
                log.error("send analytics was interrupted by: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return result;
        }, executor);
    }

    private void resultProcessing(String message, String errorMessage, Future<Integer> action) {
        try {
            log.info("{}: {}", message, action.get(1, TimeUnit.MINUTES));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error("{}: {}", errorMessage, e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
    }

    public void doAll() {
        Future<Integer> payment = collectPayment();
        Future<Integer> analytics = sendAnalytics();

        while (true) {
            if (analytics.isDone() && payment.isDone()) {
                break;
            }
        }
        resultProcessing("send analytics", "analytical data has not been transmitted", analytics);
        resultProcessing("collect payment", "payment failed", payment);

        executor.shutdown();
    }
}
