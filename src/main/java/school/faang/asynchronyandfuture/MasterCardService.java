package school.faang.asynchronyandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {

    //константа для 10ти и 1-ой секунды
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int DEFAULT_PAYMENT = 5_000;
    private static final int ANALYTICS_VALUE = 17_000;

    public static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return DEFAULT_PAYMENT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_VALUE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectFuture = executor.submit(MasterCardService::collectPayment);

        try {
            int resultPayment = collectFuture.get();
            log.info("Платеж выполнен {}", resultPayment);
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
        } finally {
            executor.shutdown();
        }

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        int analyticsResult = analyticsFuture.join();

        log.info("Аналитика отправлена {}", analyticsResult);
    }
}