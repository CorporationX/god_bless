package school.faang.multithreading.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException err) {
            throw new IllegalStateException("Поток прерван до или во время выполнения действия", err);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException err) {
            throw new IllegalStateException("Поток прерван до или во время выполнения действия", err);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> paymentResult = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics,
                executorService
        );

        try {
            int payment = paymentResult.get();

            analyticsResult.thenAccept(result -> {
                System.out.println("Аналитика отправлена: " + result);
                System.out.println("Платеж выполнен: " + payment);
            });
        } catch(InterruptedException | ExecutionException err) {
            throw new IllegalStateException("Поток прерван до или во время выполнения действия", err);
        }

        executorService.shutdown();
    }
}
