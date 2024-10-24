package school.faang.fourthStream.BJS2_38743;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionCollector {
    private static final int TERMINATION_SECONDS = 20;
    private static final AtomicInteger TOTAL_INGREDIENTS = new AtomicInteger(0);

    public static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService executor = Executors.newFixedThreadPool(potions.size());

        potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(potion::gatherIngredients, executor))
                .toList().stream()
                .mapToInt(CompletableFuture::join)
                .forEach(ingredientCount -> TOTAL_INGREDIENTS.accumulateAndGet(ingredientCount, Integer::sum));

        shutdown(executor);
       log.info("Общее количество собранных ингредиентов: {} \n", TOTAL_INGREDIENTS.get());
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
        }
    }
}
