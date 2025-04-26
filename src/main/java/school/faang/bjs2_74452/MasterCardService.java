package school.faang.bjs2_74452;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT = 5_000;
    private static final int ANALYTICS = 17_000;
    private static final int MAX_EXPECTATION = 60;

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT;
        } catch (InterruptedException e) {
            log.error("Thread stopped error");
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS;
        } catch (InterruptedException e) {
            log.error("Thread stopped error");
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> payment = CompletableFuture.supplyAsync(this::collectPayment, pool);
        payment.thenAccept(pay -> log.info("Paid in the amount of {}", pay)).join();

        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics, pool);
        analytics.thenAccept(analyst -> log.info("The analytics amounted to {} data points", analyst)).join();

        gracefullyShutdown(pool);
    }

    private static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            boolean isClose = executorService.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            executorService.shutdownNow();
        }
    }
}
