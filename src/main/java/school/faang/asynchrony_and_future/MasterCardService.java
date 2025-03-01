package school.faang.asynchrony_and_future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);

    public CompletableFuture<Integer> collectPaymentAsync() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(10);
            return 5_000;
        });
    }

    public CompletableFuture<Integer> sendAnalyticsAsync() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return 17_000;
        });
    }

    private void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}