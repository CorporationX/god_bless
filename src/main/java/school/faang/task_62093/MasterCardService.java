package school.faang.task_62093;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    public int collectPayment(int sum) {
        System.out.println("Ожидаем ответ от сервера для платежа...");
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            System.out.println("Оплата прошла успешно!");
            return sum;
        } catch (InterruptedException e) {
            System.out.println("Ошибка оплаты, поток прерван! " + e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics(int data) {
        System.out.println("Ожидаем ответ от сервера для аналитики...");
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            System.out.println("Аналитика отправлена успешна!");
            return data;
        } catch (InterruptedException e) {
            System.out.println("Ошибка отправки, поток прерван! " + e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executorService.submit(() -> collectPayment(5000));
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics(17000));
        analyticsFuture.thenAccept(data -> System.out.printf("Аналитика отправлена: %d%n", data)).join();
        try {
            Integer paymentResult = paymentFuture.get();
            System.out.printf("Платеж выполнен: %d%n ", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ошибка выполнения задачи: " + e);
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }
}
