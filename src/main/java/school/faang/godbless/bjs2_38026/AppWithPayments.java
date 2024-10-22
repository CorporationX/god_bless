package school.faang.godbless.bjs2_38026;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


@Slf4j
public class AppWithPayments {
    private static final int WAIT_TIME = 20000;

    @Getter
    private static final AppWithPayments instance = new AppWithPayments();
    private final MasterCardService paymentService = MasterCardService.getInstance();

    private AppWithPayments() {
    }

    public void doAll() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> paymentAmount = pool.submit(paymentService::collectPayment);
        CompletableFuture<Void> sendingAnalyticsResult = CompletableFuture
                .runAsync(() -> paymentService.sendAnalytics("some analytics"));
        try {
            int paymentSum = paymentAmount.get(WAIT_TIME, TimeUnit.MILLISECONDS);
            log.info("Collected payment sum {}", paymentSum);
        } catch (ExecutionException | TimeoutException e) {
            log.error("Failed to collect payment");
        }
        try {
            sendingAnalyticsResult.get(WAIT_TIME, TimeUnit.MILLISECONDS);
            log.info("Successfully sent analytics");
        } catch (ExecutionException | TimeoutException e) {
            log.error("Failed to send analytics");
        }
        pool.shutdownNow();
    }
}
