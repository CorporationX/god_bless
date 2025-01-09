package school.faang.task_51672;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class IngredientCollector {
    private final ExecutorService executorService;
    private final long timeToCollectIngredient = 500L;

    public CompletableFuture<Integer> gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() ->
                        gatherIngredients(potion), executorService)
                ).toList();

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenApply(v -> futures.stream()
                        .mapToInt(CompletableFuture::join)
                        .sum())
                .exceptionally(ex -> {
                    log.error("Error occurred while gathering process: {}",
                            ex.getMessage());
                    return 0;
                });
    }

    private int gatherIngredients(Potion potion) {
        long gatheringTime = timeToCollectIngredient * potion.requiredIngredients();
        try {
            Thread.sleep(gatheringTime);
        } catch (InterruptedException e) {
            log.error("Error occurred: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        return potion.requiredIngredients();
    }

    public void finishCollecting(long time) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(time, TimeUnit.SECONDS)) {
                log.info("Not all schools have completed their assignments.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error occurred: {}", e.getMessage());
            executorService.shutdownNow();
        }
    }
}
