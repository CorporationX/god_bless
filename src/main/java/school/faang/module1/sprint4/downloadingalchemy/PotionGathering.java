package school.faang.module1.sprint4.downloadingalchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int TIME_GATHER_INGREDIENTS_MS = 1_000;
    private static final AtomicInteger TOTAL_SUM = new AtomicInteger(0);

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(TIME_GATHER_INGREDIENTS_MS);
        } catch (InterruptedException e) {
            log.debug("Во время сбора ингредиентов поток прервался", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Сбор ингредиентов был прерван", e);
        }

        return potion.requiredIngredients();
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        CompletableFuture<?>[] resultsGatherIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion)
                        .thenApply(PotionGathering::gatherIngredients))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<AtomicInteger> sumFuture = CompletableFuture.allOf(resultsGatherIngredients)
                .thenApply(futureResult -> {
                    for (var future : resultsGatherIngredients) {
                        try {
                            TOTAL_SUM.addAndGet((Integer) future.get());
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return TOTAL_SUM;
                });

        try {
            AtomicInteger sum = sumFuture.get();
            log.info("Общее количество собранных ингредиентов: {}", sum);
        } catch (InterruptedException | ExecutionException e) {
            log.debug("Поток был прерван при получении общей суммы", e);
            throw new RuntimeException(e);
        }
    }
}
