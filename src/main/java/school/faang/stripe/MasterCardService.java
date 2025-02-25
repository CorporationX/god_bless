package school.faang.stripe;

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
    private static final int AWAIT_TERMINATION_TIMEOUT = 5;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void doAll() {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        try {
            int analyticsResult = analyticsFuture.join();
            log.info("Аналитика отправлена: {}", analyticsResult);
            int paymentResult = paymentFuture.get();
            log.info("Платеж выполнен: {}", paymentResult);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван во время получения аналитики", e);
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Не удалось извлечь платежные данные", e);
            throw new RuntimeException(e);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Поток не завершил свою работу в установленный срок. Принудительно завершаю поток...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван во время ожидания остановки его работы");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            log.error("Поток прерван во время отправки платежа: ", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван во время отправки аналитики: ", e);
            throw new RuntimeException(e);
        }
    }
}
