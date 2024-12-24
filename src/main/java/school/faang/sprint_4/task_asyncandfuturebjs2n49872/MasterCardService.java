package school.faang.sprint_4.task_asyncandfuturebjs2n49872;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> collectPaymentResult = executor.submit(this::collectPayment);
        Future<Integer> sendAnalyticsResult = executor.submit(this::sendAnalytics);

        int analyticsResult = sendAnalyticsResult.get();
        log.info("Analytics result = {}", analyticsResult);
        int paymentResult = collectPaymentResult.get();
        log.info("Payment result = {}", paymentResult);
    }
}
