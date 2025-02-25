package school.faang.sprint.fourth.async;

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
    private static final int ANALYTICS_VALUE = 17_000;
    private static final int PAYMENT_VALUE = 5_000;
    private static final int THREAD_COUNT = 2;
    private static final int AWAIT_TERMINATION_TIMEOUT = 25;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_VALUE;
        } catch (InterruptedException e) {
            log.error("Thread interrupted {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_VALUE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            if (analyticsFuture.get() == null) {
                log.info("Waiting collect analytic");
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("Thread interrupted {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        try {
            if (paymentFuture.get() == null) {
                log.info("Waiting payment");
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("Thread interrupted {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        if (paymentFuture.isDone()) {
            try {
                log.info("Аналитика отправлена: {}", analyticsFuture.get());
                log.info("Платеж выполнен: {}", paymentFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                executor.shutdownNow();
                throw new RuntimeException(e);
            }
        }

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Thread interrupted {}", e.getMessage());
            executor.shutdownNow();
        }

    }
}