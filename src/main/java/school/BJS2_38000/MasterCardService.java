package school.BJS2_38000;

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

    public void doAll() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(() -> collectPayment());
        CompletableFuture.supplyAsync(() -> sendAnalytics(), executor)
                .thenAccept(result -> System.out.println("Аналитика отправлена: " + result))
                .join();
        int result = future1.get();
        System.out.println("Платеж выполнен: " + result);
        executor.shutdown();
    }


}
