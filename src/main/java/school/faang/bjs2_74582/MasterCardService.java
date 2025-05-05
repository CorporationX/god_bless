package school.faang.bjs2_74582;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int THREADS_COUNT = 2;
    private static final int ANALYTIC_DURATION = 1000;
    private static final int PAYMENT_DURATION = 10000;
    private static final int PAYMENT_SIZE = 17000;
    private static final int TERMINATION_WAIT_DURATION = 17000;

    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

    public int collectPayment(int size) {
        try {
            Thread.sleep(PAYMENT_DURATION);
        } catch (InterruptedException e) {
            log.error("Interrupted exception was thrown", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Payments collected");
        return size;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ANALYTIC_DURATION);
        } catch (InterruptedException e) {
            log.error("Interrupted exception was thrown", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Analytics was sent");
        return 0;
    }

    public void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_WAIT_DURATION, TimeUnit.SECONDS)) {
                log.warn("Not all tasks finished successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception was thrown", e);
            executorService.shutdownNow();
        }
    }

    public void doAll() {
        Future<Integer> collectPaymentFuture = executorService.submit(() -> collectPayment(PAYMENT_SIZE));
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(this::sendAnalytics, executorService);
        try {
            collectPaymentFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        future.join();
        log.info("Finish method doAll");
    }
}