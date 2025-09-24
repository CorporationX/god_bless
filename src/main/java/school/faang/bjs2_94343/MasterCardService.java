package school.faang.bjs2_94343;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 5_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int COLLECT_PAYMENT_RETURN_VALUE = 5_000;
    private static final int SEND_ANALYTICS_RETURN_VALUE = 17_000;

    private static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return COLLECT_PAYMENT_RETURN_VALUE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return SEND_ANALYTICS_RETURN_VALUE;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAllOperations() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> collectPaymentFuture = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executorService);

        int sendAnalyticsResult = sendAnalyticsFuture.join();
        System.out.println(sendAnalyticsResult);

        int collectPaymentResult = collectPaymentFuture.get();
        System.out.println(collectPaymentResult);
        executorService.shutdown();
    }
}
