package school.faang.asynchrony_and_future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);
    public static final int PAYMENT_DELAY_SECONDS = 1;
    public static final int ANALYTICS_DELAY_SECONDS = 10;
    public static final int PAYMENT_AMOUNT = 5_000;
    public static final int ANALYTICS_RESULT = 17_000;

    public CompletableFuture<Integer> collectPaymentAsync() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(ANALYTICS_DELAY_SECONDS);
            return PAYMENT_AMOUNT;
        });
    }

    public CompletableFuture<Integer> sendAnalyticsAsync() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(PAYMENT_DELAY_SECONDS);
            return ANALYTICS_RESULT;
        });
    }

    private void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            MasterCardService.logger.info("Что-то пошло не так");
            throw new RuntimeException(e);
        }
    }
}