package school.faang.asyncandfuturebjs49984;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    private static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);
    private static final int PAYMENT_DELAY = 10_000;
    private static final int ANALYTICS_DELAY = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_DELAY);
            return PAYMENT_DELAY;
        } catch (InterruptedException e) {
            logger.error("Error during payment processing", e);
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_DELAY);
            return ANALYTICS_DELAY;
        } catch (InterruptedException e) {
            logger.error("Error when sending analytics", e);
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> paymentFuture = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                return collectPayment();
            }
        });

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(() ->
                sendAnalytics());

        try {
            int analitycsResult = analyticsFuture.get();
            logger.info("The analysis has been sent: {}", analitycsResult);

            int paymentResult = paymentFuture.get();
            logger.info("Payment completed: {}", paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Error when performing operations: ", e);
        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
