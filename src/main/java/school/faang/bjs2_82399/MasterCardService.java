package school.faang.bjs2_82399;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public static int collectPayment() {
        log.info("Тут производится процесс оплаты");
        try {
            TimeUnit.MILLISECONDS.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка в процессе оплаты", e);
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        log.info("Тут имитация процесса отправки аналитики");
        try {
            TimeUnit.MILLISECONDS.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка в процессе отправки аналитики", e);
            throw new RuntimeException(e);
        }
    }

    public void doAll(ExecutorService poolThread) {
        Future<Integer> payment = poolThread.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> resultAnalytics = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics, poolThread
        );

        resultAnalytics.thenAccept(result -> log.info("Аналитика выполнена: {}", result))
                        .exceptionally(e -> {
                            log.error("Ошибка аналитики: {}", e.getMessage());
                            return null;
                        });

        try {
            log.info("Платеж выполнен: {}", payment.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван во время ожидания", e);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            String errorMsg = (cause != null) ? cause.getMessage() : "Причина неизвестна";
            log.error("Ошибка выполнения: {}", errorMsg, e);
        } catch (CancellationException e) {
            log.error("Задача была отменена: {}", e.getMessage());
        }
    }
}
