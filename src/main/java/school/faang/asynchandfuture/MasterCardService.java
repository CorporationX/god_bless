package school.faang.asynchandfuture;

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

    public void doAll(ExecutorService executor) {
        Future<Integer> futureResult = executor.submit(() -> collectPayment());

        CompletableFuture<Void> analyticsFuture = CompletableFuture.supplyAsync(() -> sendAnalytics())
                .thenAccept(result -> System.out.println("Аналитика отправлена: " + result));

        try {
            analyticsFuture.join();

            int result = futureResult.get();
            System.out.println("Платеж выполнен: " + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
