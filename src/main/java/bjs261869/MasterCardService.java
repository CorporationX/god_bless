package bjs261869;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int COLLECT_PAYMENT_THREAD_SLEEP_IN_MS = 10000;
    private static final int STANDARD_PAYMENT_AMOUNT = 5000;
    private static final int ANALYTICS_RESULT_CODE = 17000;
    private static final int COLLECT_ANALYTICS_THREAD_SLEEP_IN_MS = 1000;

    private static final int AWAIT_TERMINATION_IN_MS = 1000;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_THREAD_SLEEP_IN_MS);
        } catch (InterruptedException e) {
            log.error("Thread {} interrupted", Thread.currentThread().getId(),
                    new StripeException("Interrupted exception"));
            Thread.currentThread().interrupt();
        }
        return STANDARD_PAYMENT_AMOUNT;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(COLLECT_ANALYTICS_THREAD_SLEEP_IN_MS);
        } catch (InterruptedException e) {
            log.error("Thread {} interrupted", Thread.currentThread().getId(),
                    new StripeException("Interrupted exception"));
            Thread.currentThread().interrupt();
        }
        return ANALYTICS_RESULT_CODE;
    }

    public void doAll() {
        Future<Integer> paymentFuture = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        log.info("Аналитика отправлена: {}", analyticsFuture.join());
        try {
            log.info("Платёж выполнен: {}", paymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception {} in thread: {}", e, Thread.currentThread().getId(),
                    new StripeException("The process of receiving the payment result has been interrupted"));
            Thread.currentThread().interrupt();
        }
    }

    public void shutDownExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_IN_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
