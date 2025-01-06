package school.faang.task_bjs250024;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentResult = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsResult = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics);

        System.out.println("Аналитика отправлена: " + analyticsResult.join());
        try {
            System.out.println("Платеж получен: " + paymentResult.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
