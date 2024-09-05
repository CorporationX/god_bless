package faang.school.godbless.BJS2_24890;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCardService {
    public static void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics).thenAccept(result ->
                System.out.println("Отправили аналитику, результат: " + result));

        try {
            System.out.println("Собрали платеж, результат: " +
                    executorService.submit(MasterCardService::collectPayment).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

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
}
