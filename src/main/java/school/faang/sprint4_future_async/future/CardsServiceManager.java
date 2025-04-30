package school.faang.sprint4_future_async.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class CardsServiceManager {

    public void doAll() {
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics)
                .thenAccept((result) -> System.out.println("Аналитика отправлена:" + result))
                .join();

        pay();
    }

    private void pay() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        try {
            var result = paymentFuture.get();
            System.out.printf("Платеж выполнен: %d.", result);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка. главный поток остановлен.");
            throw new RuntimeException();
        }
    }
}