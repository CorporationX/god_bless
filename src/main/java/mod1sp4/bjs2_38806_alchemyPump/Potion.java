package mod1sp4.bjs2_38806_alchemyPump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;
    private static final Random RANDOMIZER = new Random();
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            long gatheringTimeoutByAmountIngredients = RANDOMIZER.nextLong(potion.getRequiredIngredients());
            try {
                Thread.sleep(gatheringTimeoutByAmountIngredients);
            } catch (InterruptedException e) {
                log.error("\nThread was interrupted while he was sleeping");
                throw new IllegalStateException(e);
            }
            log.info("\nIngredients for {} was gather", potion.getName());
            return potion.getRequiredIngredients();
        }, executor);
    }

    public static void shuttingDownExecutor() {
        executor.shutdown();
        try {
            if (executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error shutting down executor: {}", e.getMessage());
            throw new IllegalStateException(e);
        }
    }
}
