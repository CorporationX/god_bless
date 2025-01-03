package school.faang.task_49961;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

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
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentFuture = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> sendAnalyticsCompletableFuture = CompletableFuture.supplyAsync(() ->
                sendAnalytics());

        try {
            Integer collectPaymentResult = collectPaymentFuture.get();
            Integer sendAnalyticsCompletableFutureResilt = sendAnalyticsCompletableFuture.join();

            System.out.println("Аналитика отправлена: " + sendAnalyticsCompletableFutureResilt);
            System.out.println("Платеж выполнен: " + collectPaymentResult);
            executor.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
