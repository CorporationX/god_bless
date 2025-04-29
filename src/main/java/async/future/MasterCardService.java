package async.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_TIMEOUT = 10000;
    private static final int ANALYTICS_TIMEOUT = 10000;
    private static final int PAYMENT_PRICE = 5000;
    private static final int ANALYTICS_RESULT = 17000;
    private final ExecutorService executor;

    public MasterCardService(ExecutorService executor) {
        this.executor = executor;
    }

    public int collectPayment() {
        log.info("Payment is starting...");
        try {
            log.info("Payment is running...");
            Thread.sleep(PAYMENT_TIMEOUT);
            return PAYMENT_PRICE;
        } catch (InterruptedException e) {
            log.info("Payment is interrupted! {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        log.info("Analytics is starting...");
        try {
            log.info("Analytics is running...");
            Thread.sleep(ANALYTICS_TIMEOUT);
            return ANALYTICS_RESULT;
        } catch (InterruptedException e) {
            log.info("Analytics is interrupted! {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        Integer analyticsResult = CompletableFuture.supplyAsync(() -> sendAnalytics(), executor).join();
        Integer paymentResult;
        try {
            paymentResult = executor.submit(() -> collectPayment()).get();
        } catch (ExecutionException e) {
            log.error("Error during payment processing: " + e.getCause().getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            log.error("Thread interrupted while waiting for payment result.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        executor.shutdown();
        System.out.printf("Аналитика отправлена: %d%nПлатеж выполнен: %d", analyticsResult, paymentResult);
    }
}
