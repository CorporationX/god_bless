package school.faang.bjs2_74440;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {

    private static final int FIVE_SECONDS_IN_MS = 5_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int TERMINATION_TIME = 10;
    private static final int THREAD_POOL = 4;
    private static final ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL);

    static int collectPayment() {
        try {
            Thread.sleep(FIVE_SECONDS_IN_MS);
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

    public void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> collect = pool.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> send = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, pool);

        int sentAnalyticsResult = send.join();
        log.info("Sent analytics -> {}", sentAnalyticsResult);

        int collectedPaymentResult = collect.get();
        log.info("Collected -> {}", collectedPaymentResult);

        terminateExecution();
    }

    private void terminateExecution() {
        pool.shutdown();

        try {
            if (!pool.awaitTermination(TERMINATION_TIME, TimeUnit.SECONDS)) {
                log.info("Задачи не завершились за {} минут, принудительно останавливаем...", TERMINATION_TIME);
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
    }
}
