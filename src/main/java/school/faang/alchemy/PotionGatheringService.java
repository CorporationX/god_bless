package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class PotionGatheringService {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int gatheringTime = potion.getRequiredIngredients() * 1000;
                Thread.sleep(gatheringTime);
                return potion.getRequiredIngredients();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Сбор прерван для {}", potion.getName(), e);
                throw new RuntimeException("Сбор ингредиентов прерван", e);
            }
        }, executor);
    }

    public void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(this::gatherIngredients)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        allFutures.thenApply(value -> futures.stream()
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum)
        ).thenAccept(total -> log.info("Общее количество собранных ингредиентов: {}", total));
        executor.shutdown();
    }

}
