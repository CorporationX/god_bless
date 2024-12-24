package school.faang.sprint_4.task_asyncandfuturebjs2n49872;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static int COLLECT_PAYMENT_DELAY = 10_000;
    private static int SEND_ANALYTICS_DELAY = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(COLLECT_PAYMENT_DELAY);
            return COLLECT_PAYMENT_DELAY;
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return 0;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTICS_DELAY);
            return SEND_ANALYTICS_DELAY;
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return 0;
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> collectPaymentResult = executor.submit(MasterCardService::collectPayment);
        Future<Integer> sendAnalyticsResult = executor.submit(MasterCardService::sendAnalytics);

        int analyticsResult = sendAnalyticsResult.get();
        log.info("Analytics result = {}", analyticsResult);
        int paymentResult = collectPaymentResult.get();
        log.info("Payment result = {}", paymentResult);

        executor.shutdown();
    }
}
