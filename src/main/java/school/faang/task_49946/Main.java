package school.faang.task_49946;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor)
                        .thenAccept(result -> System.out.println("Аналитика отправлена: " + result));

        try {
            Future<Integer> future = executor.submit(MasterCardService::collectPayment);
            int futureResult = future.get();
            System.out.println("Платеж выполнен: " + futureResult);
            analyticsFuture.join();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка отправки платежа" + e);
            throw new RuntimeException(e);
        }
        executor.shutdown();
        log.info("Все потоки завершены");
    }
}
