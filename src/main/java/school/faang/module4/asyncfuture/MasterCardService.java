package school.faang.module4.asyncfuture;

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
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

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
        Future<Integer> paymentOperation = EXECUTOR_SERVICE.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsOperation = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics, EXECUTOR_SERVICE
        );

        try {
            int analyticsResult = analyticsOperation.join();
            log.info("Аналитика отправлена: {}", analyticsResult);

            int paymentResult = paymentOperation.get();
            log.info("Платеж выполнен: {}", paymentResult);

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        } finally {
            EXECUTOR_SERVICE.shutdown();
        }
    }
}
