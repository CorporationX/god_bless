package school.faang.pumpingupalchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int DURATION_MS = 2000;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Собираем ингредиенты для {}", potion.getName());
                Thread.sleep(DURATION_MS);
            } catch (InterruptedException e) {
                log.error("Поток прерван");
                Thread.currentThread().interrupt();
            }
            log.info("Ингредиенты для {} собраны в количестве {}", potion.getName(), potion.getRequiredIngredients());
            return potion.getRequiredIngredients();
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach((future) -> totalIngredients.addAndGet(future.join()));

        int total = totalIngredients.get();
        log.info("Общее количество собранных ингредиентов: {}", total);
    }
}
