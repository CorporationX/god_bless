package school.faang.bjs_49883;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Getter
public class ServiceRunner {
    private static final int WAIT_TIME_SECONDS = 20;
    private static final int THREAD_POOL_SIZE = 5;
    private int resultPayment;
    private int resultAnalytics;

    public void runService() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        MasterCardService masterCardService = new MasterCardService();
        Future<Integer> paymentFuture = executor.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(masterCardService::sendAnalytics, executor);

        try {
            resultPayment = paymentFuture.get(WAIT_TIME_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error("Payment error", e);
        }

        resultAnalytics = analyticsFuture.join();
        log.info("Payment result: {}", resultPayment);
        log.info("Analytic result: {}", resultAnalytics);
    }
}
