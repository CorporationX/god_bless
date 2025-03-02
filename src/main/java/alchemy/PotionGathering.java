package alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int TERMINATION_TIME_SEC = 60;
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion)
                        .thenAccept(ingredients -> {
                            totalIngredients.addAndGet(ingredients);
                            log.info("Gathered {} ingredients for: {}", ingredients, potion.getName());
                        }))
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        log.info("Total ingredients gathered: {}", totalIngredients.get());
        shutdownExecutor();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        EXECUTOR.schedule(() -> {
            log.info("Gathering ingredients for: {}", potion.getName());
            future.complete(potion.getRequiredIngredients());
        }, potion.getRequiredIngredients(), TimeUnit.SECONDS);
        return future;
    }

    private static void shutdownExecutor() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TERMINATION_TIME_SEC, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
                log.error("Failed to terminate executor");
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
