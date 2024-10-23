package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class PotionGathering {
    private final int TREAD_POOL_SIZE = 10;
    private final int TIME_OF_COLLECTION_INGREDIENTS = 5_000;

    private final ExecutorService executorService = Executors.newFixedThreadPool(TREAD_POOL_SIZE);

    public void gatherAllIngredients(List<Potion> potions) {

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> CompletableFuture
                        .supplyAsync(() -> gatherIngredients(potion), executorService)
                        .exceptionally(e -> {
                            log.error(e.getMessage());
                            throw new IllegalStateException(e);
                        }))
                .toList();

        CompletableFuture<Void> allIngredients = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allIngredients.thenRun(() -> {
            int result = completableFutures.stream()
                    .map(CompletableFuture::join)
                    .reduce(Integer::sum)
                    .orElse(-1);

            System.out.printf("Общее количество собранных ингредиентов: %d\n", result);
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }

    private int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(TIME_OF_COLLECTION_INGREDIENTS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new IllegalStateException(e);
        }
        return potion.getRequiredIngredients();
    }
}
