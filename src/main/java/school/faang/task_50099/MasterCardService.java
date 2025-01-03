package school.faang.task_50099;

import java.util.concurrent.*;

public class MasterCardService {

    public void doAll() {
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> paymentResult = executor.submit(() -> collectPayment());
            CompletableFuture<Integer> analyticsResult =
                    CompletableFuture.supplyAsync(() -> sendAnalytics());

            System.out.println("Аналитика отправлена: " + analyticsResult.join());
            System.out.println("Платеж выполнен: " + paymentResult.get());

            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int collectPayment() {
        try {
            System.out.println("Происходит оплата...");
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            System.out.println("Отправляем метрики по оплате...");
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
