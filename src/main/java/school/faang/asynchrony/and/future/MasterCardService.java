package school.faang.asynchrony.and.future;

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
    private static final int PAYMENT_AM0UNT = 5_000;
    private static final int ANALYTICS_RESULT = 17_000;
    private static final int AWAIT_TERMINATION_TIMEOUT = 5;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_AM0UNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = analyticsFuture.join();
        log.info("Analytics sent: {}", analyticsResult);

        try {
            Integer paymentResult = paymentFuture.get();
            log.info("Payment completed: {}", paymentResult);
        } catch (InterruptedException e) {
            log.error("Payment execution error", e);
        } catch (ExecutionException e) {
            log.error("Payment execution error", e);
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                    log.warn("ExecutorService didn`t terminate within the timeout");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Interrupted while waiting for ExecutorService to terminate", e);
            }
        }
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
