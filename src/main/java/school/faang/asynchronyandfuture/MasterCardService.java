package school.faang.asynchronyandfuture;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    public static final int PAYMENT_DURATION_MS = 10000;
    public static final int SENDING_DURATION_MS = 1000;

    public int collectPayment() {
        log.info("Payment in progress");
        try {
            Thread.sleep(PAYMENT_DURATION_MS);
            return 10000;
        } catch (InterruptedException e) {
            log.error("Payment wasn't completed");
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        log.info("Sending analytics in progress");
        try {
            Thread.sleep(SENDING_DURATION_MS);
            return 1000;
        } catch (InterruptedException e) {
            log.error("Analytics wasn't sent");
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executorPayment = Executors.newSingleThreadExecutor();
        Future<Integer> futurePayment = executorPayment.submit(this::collectPayment);
        Integer paymentResult;
        try {
            paymentResult = futurePayment.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        log.info("Payment completed: {}", paymentResult);

        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        Integer analyticsResult = futureAnalytics.join();
        log.info("Analytics sent: {}", analyticsResult);

        executorPayment.shutdown();
    }
}
