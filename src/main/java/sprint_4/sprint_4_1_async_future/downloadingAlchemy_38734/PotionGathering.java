package sprint_4.sprint_4_1_async_future.downloadingAlchemy_38734;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class PotionGathering {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
        log.info("threadId: {}", Thread.currentThread().getId());
        EXECUTOR.shutdown();
    }

    private static void gatherAllIngredients(List<Potion> potions) {

        List<CompletableFuture<Integer>> vladiki = potions.stream()
                .map(PotionGathering::getCountIngredientsFromPotion)
                .toList();

        CompletableFuture.allOf(vladiki.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    int collectedIngredients = vladiki.stream().mapToInt(CompletableFuture::join).sum();
                    log.info("collectedIngredients: {}, {}", collectedIngredients, Thread.currentThread().getId());
                });
    }

    private static CompletableFuture<Integer> getCountIngredientsFromPotion(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        }, EXECUTOR);
    }
}
