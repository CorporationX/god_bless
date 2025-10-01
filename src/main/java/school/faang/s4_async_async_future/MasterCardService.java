package school.faang.s4_async_async_future;

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

    public void doAll() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(() -> MasterCardService.collectPayment());

        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(() -> MasterCardService.sendAnalytics());

        Integer analyticsResult = analyticsFuture.join();
        System.out.printf("Аналитика отправлена: %s%n", analyticsResult);

        Integer paymentResult = paymentFuture.get();
        System.out.printf("Платеж выполнен:  %s%n", paymentResult);
    }
}
