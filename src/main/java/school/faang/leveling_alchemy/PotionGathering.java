package school.faang.leveling_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final long TIME_PER_INGREDIENT = 200;

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.requiredIngredients() * TIME_PER_INGREDIENT);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted while gathering ingredients for {}", potion.name(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("{}: gathered {} ingredients", potion.name(), potion.requiredIngredients());
            return potion.requiredIngredients();
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {

        AtomicInteger total = new AtomicInteger();

        var tasks = potions.stream()
                .map(p -> gatherIngredients(p)
                        .thenAccept(total::addAndGet))
                        .toList();

        CompletableFuture
                .allOf(tasks.toArray(new CompletableFuture[0]))
                .join();

        log.info("Total ingredients gathered: {}", total.get());
    }
}
