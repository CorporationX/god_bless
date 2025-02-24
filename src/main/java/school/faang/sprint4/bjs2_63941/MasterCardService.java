package school.faang.sprint4.bjs2_63941;

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
    private static final int THREAD_POOL_SIZE = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при выполнении collectPayment {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при выполнении sendAnalytics {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        Future<Integer> futurePayment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics,
                executorService);
        try {
            Integer analyticsResult = futureAnalytics.get();
            log.info("[Поток {}] Аналитика отправлена: {}", Thread.currentThread().getId(), analyticsResult);

            Integer paymentResult = futurePayment.get();
            log.info("[Поток {}] Платеж выполнен: {}", Thread.currentThread().getId(), paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            log.error("[Поток {}] Ошибка при выполнении асинхронных задач: {}", Thread.currentThread().getId(),
                    e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
