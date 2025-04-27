package school.faang.async.async_and_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int TERMINATION_IN_MS = 20_000;

    public static int collectPayment() {
        return 5_000;
    }

    public static int sendAnalytics() {
        return 17_000;
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Future<Integer> payment = executorService.schedule(MasterCardService::collectPayment, TEN_SECONDS_IN_MS,
                TimeUnit.MILLISECONDS);

        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics,
                CompletableFuture.delayedExecutor(ONE_SECOND_IN_MS, TimeUnit.MILLISECONDS));

        log.info("Платеж выполнен: {}", payment.get());
        log.info("Аналитика отправлена: {}", analytics.join());

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TERMINATION_IN_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
