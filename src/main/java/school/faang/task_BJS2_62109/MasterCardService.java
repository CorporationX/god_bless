package school.faang.task_BJS2_62109;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int ten_seconds_in_ms = 10_000;
    private static final int one_seconds_in_ms = 1_000;

    static int collectPayment() throws InterruptedException {
        try {
            Thread.sleep(ten_seconds_in_ms);
            return 5000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(one_seconds_in_ms);
            return 17000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Обрабатываем исключение и возвращаем дефолтное значение
            return 0; // Возврат дефолтного значения в случае прерывания
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futureCollectPayment = executor.submit(() -> collectPayment());

        // Запускаем sendAnalytics асинхронно через CompletableFuture
        CompletableFuture<Integer> futureSendAnalytics =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        // Ожидаем завершения sendAnalytics и печатаем результат
        try {
            int analyticsResult = futureSendAnalytics.get();
            System.out.println("Аналитика отправлена: " + analyticsResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Ожидаем завершения collectPayment и печатаем результат
        try {
            int collectPayment = futureCollectPayment.get();
            System.out.println("Платеж выполнен: " + collectPayment);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}