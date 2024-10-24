package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionMaker {
    private final ExecutorService executor;

    public PotionMaker(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public CompletableFuture<Integer> startGatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(potion::gatherIngredients, executor);
    }

    public AtomicInteger gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger();
        List<CompletableFuture<Void>> gatheringIngredientsProcesses = potions.stream()
                .map(potion -> startGatherIngredients(potion)
                        .thenAccept(totalIngredients::addAndGet))
                .toList();
        CompletableFuture.allOf(gatheringIngredientsProcesses.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Total amount of gathered ingredients is: " + totalIngredients.get()));
        return totalIngredients;
    }

    public void shutdownExecutorService() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in the specific time. Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Executor shutdown was interrupted", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}