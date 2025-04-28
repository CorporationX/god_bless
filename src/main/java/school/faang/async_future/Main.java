package school.faang.async_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);
    private static final int TIMEOUT_SECONDS = 11;

    public static void main(String[] args) {
        try {
            doAll();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            executor.shutdownNow();
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics,
                executor);
        System.out.printf("Analytics were sent: %d \n", analyticsFuture.join());
        System.out.printf("Payment was received: %d", paymentFuture.get());
    }
}
