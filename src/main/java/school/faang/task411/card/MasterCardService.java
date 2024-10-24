package school.faang.task411.card;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(MasterCardService::sendAnalytics);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::collectPayment, service);

        try {
            System.out.println("Аналитика отправлена: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Платеж выполнен: " + completableFuture.join());

        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("Ошибка");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
