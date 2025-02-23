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

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> payemntFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        while (!analyticsFuture.isDone()) {
            log.info("Waiting collect analytic");
        }

        if (analyticsFuture.isDone()) {
            while (!payemntFuture.isDone()) {
                log.info("Waiting payment");
            }
            if (payemntFuture.isDone()) {
                try {
                    log.info("Аналитика отправлена: {}", analyticsFuture.get());
                    log.info("Платеж выполнен: {}", payemntFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    executor.shutdownNow();
                    throw new RuntimeException(e);
                }
            }
        }

        try {
            if (!executor.awaitTermination(25, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

    }
}