package school.faang.sprint4_future_async.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CardsServiceManager {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void doAll() {
        CompletableFuture<Void> completableFutureSendAnalytics =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor)
                        .thenAccept((result) -> System.out.printf("Аналитика отправлена: %d.\n", result));

        try {
            var result = executor.submit(MasterCardService::collectPayment).get();
            System.out.printf("Платеж выполнен: %d.\n", result);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка. главный поток остановлен.\n", e);
        }

        completableFutureSendAnalytics.join();

        executorShutdown();
    }

    private void executorShutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                log.error("Задача по платежам не завершились за 2 мин, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван во время ожидания, принудительно останавливаем пул...");
            executor.shutdownNow();
        }
    }
}