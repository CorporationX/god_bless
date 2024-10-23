package school.faang.BJS2_38042_AsyncAndFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int THREAD_POOL_SIZE = 2;

    private static int collectPayment() {
        try {
            log.info("Started collecting payment...");
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted during payment collection!", Thread.currentThread().getName(), e);
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            log.info("Started sending analytics...");
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted while sending analytics!", Thread.currentThread().getName(), e);
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Future<Integer> paymentResult = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsResult =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            log.info("Received analytics result: {}", analyticsResult.get());
            log.info("Received payment result: {}", paymentResult.get());
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted while getting results of operations!", Thread.currentThread().getName(), e);
        } catch (ExecutionException e) {
            log.error("An error occurred in execution while retrieving operation results!", e);
        } finally {
            executor.shutdown();
            log.info("Executor service shutdown initiated.");
        }
    }
}
