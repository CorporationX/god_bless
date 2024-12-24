package school.faang.sprint_4.task_49877;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_TIME_SLEEP = 10;
    private static final int ANALYTICS_TIME_SLEEP = 1;
    private static final int TIMEOUT_PAYMENT = 30;
    private static final int COLLECTED_PAYMENT = 10_000;
    private static final int SENT_ANALYTICS = 1_000;

    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = service.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try {
            Integer resultSendAnalytics = analyticsFuture.join();
            log.info("Analytics sent: {}", resultSendAnalytics);

            Integer resultCollectPayment = paymentFuture.get(TIMEOUT_PAYMENT, TimeUnit.SECONDS);
            log.info("Payment sent: {}", resultCollectPayment);
            service.shutdown();
        } catch (Exception e) {
            log.error("Error message: ", e);
        }

    }

    public static int collectPayment() {
        try {
            TimeUnit.SECONDS.sleep(PAYMENT_TIME_SLEEP);
        } catch (InterruptedException e) {
            log.error("Error message: ", e);
        }
        return COLLECTED_PAYMENT;
    }

    public static int sendAnalytics() {
        try {
            TimeUnit.SECONDS.sleep(ANALYTICS_TIME_SLEEP);
        } catch (InterruptedException e) {
            log.error("Error message: ", e);
        }
        return SENT_ANALYTICS;
    }
}
