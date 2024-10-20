package school.faang.asyncAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private final static int THREAD_POOL_COUNT = 2;

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

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_COUNT);

        CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executor)
                .thenAccept(analytics ->
                        System.out.println("Аналитика отправлена: " + analytics))
                .exceptionally(e -> {
                    System.err.println("Не удалось отправить аналитику: " + e.getMessage());
                    return null;
                })
                .join();

        Future<Integer> futurePayment =
                executor.submit(MasterCardService::collectPayment);

        try {
            int paymentResult = futurePayment.get();
            System.out.println("Платеж выполнен: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Ошибка при выполнении платежа: +" +
                    e.getMessage());
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Время ожидания истекло," +
                        " все задачи будут прерваны.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Shutdown прерван: " + e.getMessage());
        }
    }
}
