package school.faang.task62119;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_RESULT = 5_000;
    private static final int ANALYTICS_RESULT = 17_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return PAYMENT_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService paymentExecutor = Executors.newSingleThreadExecutor();
        ExecutorService analyticsExecutor = Executors.newSingleThreadExecutor();
        Future<Integer> futureCollectPayment = paymentExecutor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> futureSendAnalytics =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, analyticsExecutor);
        Integer sendAnalytics = futureSendAnalytics.join();
        analyticsExecutor.shutdown();
        log.info("Аналитика отправлена {}", sendAnalytics);
        try {
            log.info("Платёж обработан {}", futureCollectPayment.get());
            paymentExecutor.shutdown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
