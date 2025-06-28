package school.faang.sprint3.bjs2_82450;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class MasterCardService {
    private static final int THREAD_POOL_BATCH = 5;
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int COLLECT_PAYMENT = 5_000;
    private static final int SEND_ANALYTICS = 17_000;
    private final ExecutorService executorService;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return COLLECT_PAYMENT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return SEND_ANALYTICS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        CompletableFuture<Integer> paymentFuture = CompletableFuture.supplyAsync(
                MasterCardService::collectPayment,
                executorService
        );
        CompletableFuture<Void> sendAnalytic = CompletableFuture
                .supplyAsync(
                        MasterCardService::sendAnalytics,
                        executorService
                )
                .thenAccept(result -> System.out.println("Аналитика: " + result))
                .thenCompose(ignored -> paymentFuture)
                .thenAccept(result -> System.out.println("Платежи: " + result));
        sendAnalytic.join();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_BATCH);
        MasterCardService masterCardService = new MasterCardService(executorService);
        masterCardService.doAll();
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
