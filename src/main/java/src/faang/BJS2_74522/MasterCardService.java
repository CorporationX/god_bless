package src.faang.BJS2_74522;

import java.util.concurrent.*;

public class MasterCardService {
    private static final int TEN_SECONDS = 10;
    private static final int ONE_SECOND = 1;
    private static final int COLLECT_PAYMENT_RESULT = 5_000;
    private static final int SEND_ANALYTICS_RESULT = 17_000;

    public void doAll() {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<Integer> collectingPayment = executorService.submit(this::collectPayment);
        final CompletableFuture<Integer> sendingAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);

        try {
            final Integer collectingPaymentResult = collectingPayment.get();
            System.out.println("Collecting Payment Result: " + collectingPaymentResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        final Integer sendingAnalyticsResult = sendingAnalytics.join();
        System.out.println("Sending Analytics Result: " + sendingAnalyticsResult);
        executorService.shutdown();
    }

    private int collectPayment() {
        try {
            TimeUnit.SECONDS.sleep(TEN_SECONDS);
            return COLLECT_PAYMENT_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int sendAnalytics() {
        try {
            TimeUnit.SECONDS.sleep(ONE_SECOND);
            return SEND_ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
