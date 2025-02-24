package task_BJS2_63900;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(exception);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(exception);
        }
    }

    public void doAll() {
        CompletableFuture<Integer> futureSendAnalytics = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics);
        int sendAnalyticsResult = futureSendAnalytics.join();
        System.out.printf("Аналитика отправлена: %d\n", sendAnalyticsResult);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futureCollectPayment = executor.submit(MasterCardService::collectPayment);

        try {
            int collectPaymentResult = futureCollectPayment.get();
            System.out.printf("Платеж выполнен: %d\n", collectPaymentResult);

        } catch (InterruptedException | ExecutionException exception) {
            Thread.currentThread().interrupt();
            log.info("Thread: {} was interrupted", Thread.currentThread().getName());
        }
    }

}
