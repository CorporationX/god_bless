package school.faang.Mnogopotochka.Asinc.BJS2_38062;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int NUM_THREADS = 5;

    private static int collectPayment() {
        log.info("Начало сбора платежа");
        try {
            Thread.sleep(10_000);
            log.info("Платеж успешно собран");
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Ошибка при сборе платежа", e);
            throw new RuntimeException("Сбор платежа был прерван", e);
        }
    }

    private static int sendAnalytics() {
        log.info("Начало отправки аналитики");
        try {
            Thread.sleep(1_000);
            log.info("Аналитика успешно отправлена");
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Ошибка при отправке аналитики", e);
            throw new RuntimeException("Отправка аналитики была прервана", e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        analyticsFuture.thenAccept(result -> {
            log.info("Аналитика отправлена, результат: {}", result);
        }).join();

        try {
            log.info("Платеж обработан, результат: {}", paymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка при обработке платежа", e);
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.warn("ExecutorService принудительно завершен");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("Ошибка при завершении ExecutorService", e);
            Thread.currentThread().interrupt();
        }
        log.info("ExecutorService завершен");
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
