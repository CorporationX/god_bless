package school.faang.bjs2_94550;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
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

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> futurePaymentResult = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> futureAnalyticsResult =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        System.out.printf("Аналитика отправлена: %d%n", futureAnalyticsResult.join());
        System.out.printf("Платеж выполнен: %d%n", futurePaymentResult.get());
    }
}
