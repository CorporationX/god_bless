package school.faang.task_50033;

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

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = completableFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        Integer paymentResult = future.get();
        System.out.println("Платеж выполнен: " + paymentResult);

        executor.shutdown();
    }
}
