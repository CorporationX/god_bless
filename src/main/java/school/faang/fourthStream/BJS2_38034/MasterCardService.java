package school.faang.fourthStream.BJS2_38034;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final int THREADS_COUNT = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public void doAll() {
        CompletableFuture<Void> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor)
                .thenAccept(analytics ->
                        System.out.println("Аналитика отправлена: " + analytics))
                .exceptionally(e -> {
                    System.err.println("Не удалось отправить аналитику: " + e.getMessage());
                    return null;
                });

        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);

        try {
            int resultPayment = payment.get();
            System.out.println("Платеж выполнен: " + resultPayment);
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Не удалось провести платеж: +" +
                    e.getMessage());
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Время ожидания истекло!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Поток прерван: " + e.getMessage());
        }

        analyticsFuture.join();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return 10_000;
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return 1_000;
    }
}
