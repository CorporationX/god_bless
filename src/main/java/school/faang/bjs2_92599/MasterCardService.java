package school.faang.bjs2_92599;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_SUM = 5_000;
    private static final int ANALYTIC_SUM = 17_000;

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_MS);
            return PAYMENT_SUM;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTIC_SUM;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll(ExecutorService executor) {
        CompletableFuture<Void> paymentTask = CompletableFuture.supplyAsync(() ->
                        collectPayment(), executor)
                .thenAccept(num -> log.info("Платеж выполнен: {}", num));

        CompletableFuture<Void> analyticsTask = CompletableFuture.supplyAsync(() ->
                        sendAnalytics(), executor)
                .thenAccept(analytics ->
                        log.info("Аналитика отправлена: {}", analytics));

        CompletableFuture.allOf(paymentTask, analyticsTask).join();
    }
}
