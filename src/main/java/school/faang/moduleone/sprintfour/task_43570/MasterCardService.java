package school.faang.moduleone.sprintfour.task_43570;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> collectionResult = executor.submit(() -> collectPayment());

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> sendAnalytics(), executor);

        try {
            System.out.println("Платеж выполнен: " + collectionResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Аналитика отправлена: " + integerCompletableFuture.join());

        shutdownGracefully(executor);
    }

    private static void shutdownGracefully(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.error("часть потоков не завершили задачи в отведенное время. Останавливаем принудительно");
                executor.shutdownNow();
            }
            log.info("Все потоки завершились успешно");
        } catch (InterruptedException e) {
            log.error("Корректное завершение потоков было прервано. Останавливаем принудительно");
            executor.shutdownNow();
        }
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
