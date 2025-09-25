package school.faang.bjs2_94512;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> paymentFuture = executor.submit(() -> MasterCardService.collectPayment());

            CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() -> MasterCardService.sendAnalytics());

            int analyticsResult = analyticsFuture.get();
            System.out.println("Аналитика отправлена: " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Платёж выполнен: " + paymentResult);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
