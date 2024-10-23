package school.faang.m1s4.bjs_2_37898_crowMail;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Kingdom {
    private static final double FAILURE_CHANCE = 0.3;
    private static final int N_POOLS = 3;
    private static final int TERMINATION_SECONDS = 30;
    private static final ExecutorService SERVICE_POOL_FIXED = Executors.newFixedThreadPool(N_POOLS);

    private final String name;

    private void sendMessage(Kingdom receiver) {
        log.info("Message to {} was sent...", receiver.getName());
        sleep(2000);
        if (new Random().nextDouble() < FAILURE_CHANCE) {
            throw new RuntimeException("Crow was intercepted");
        }
    }

    public CompletableFuture<Void> sendRaven(Kingdom receiver) {
        return CompletableFuture.runAsync(() -> sendMessage(receiver), SERVICE_POOL_FIXED)
                .handle((result, exception) -> {
                    if (exception != null) {
                        log.error("Delivery failed --- {}", exception.getMessage());
                    } else {
                        log.info("Message to {} from {} was delivered successfully", receiver.getName(), this.getName());
                    }
                    return null;
                });
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }

    public static void shutdownPool() {
        SERVICE_POOL_FIXED.shutdown();
        try {
            if (!SERVICE_POOL_FIXED.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                SERVICE_POOL_FIXED.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
