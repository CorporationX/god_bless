package school.faang.mastercard;

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
    private static final int PAYMENT_AMOUNT = 5_000;
    private static final int ANALYTIC_RESPONSE_VALUE = 17_000;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Payment task was interrupted", e);
        }
    }

    public static int sendAnalytic() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTIC_RESPONSE_VALUE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Analytic task was interrupted", e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> analyticFuture = CompletableFuture
                    .supplyAsync(MasterCardService::sendAnalytic, executor);
            Integer analytic = analyticFuture.join();
            log.info("Analytics sent: {}", analytic);
            Integer payment = paymentFuture.get();
            log.info("Payment completed: {}", payment);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while executing tasks", e);
        } catch (ExecutionException e) {
            throw new IllegalStateException("Execution error", e);
        } finally {
            executor.shutdown();
        }
    }
}
