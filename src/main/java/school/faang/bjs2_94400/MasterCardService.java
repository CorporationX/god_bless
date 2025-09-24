package school.faang.bjs2_94400;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10000;
    private static final int ONE_SECOND_IN_MS = 1000;
    private static final int FIFTEEN_SECOND_IN_MS = 15000;
    private static final int OPERATION_RESULT = 5_000;
    private static final int ANALYTICS_RESULT = 17_000;

    private int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            log.info("Операция по оплате успешно завершена");
            return OPERATION_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при проведении операции оплаты");
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            log.info("Результат аналитики успешно отправлен");
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при сборе результата аналитики");
            throw new RuntimeException(e);
        }
    }

    public void doAll(ExecutorService executor) {
        Future<Integer> future = executor.submit(this::collectPayment);
        try {
            int payment = future.get(FIFTEEN_SECOND_IN_MS, TimeUnit.SECONDS);
            log.info("Процесс оплаты прошел на {}", payment);
        } catch (InterruptedException e) {
            log.error("Ошибка при получении данных об оплате");
        } catch (ExecutionException e) {
            log.error("Ошибка при операции {}", e.getCause().getMessage());
        } catch (TimeoutException e) {
            log.error("Время ожидания ответа от операции оплаты истекло");
        }
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
        completableFuture.exceptionally(error -> {
            log.error("Ошибка в отправке аналитики {} - причина", error.getCause().getMessage());
            return null;
        });
    }
}
