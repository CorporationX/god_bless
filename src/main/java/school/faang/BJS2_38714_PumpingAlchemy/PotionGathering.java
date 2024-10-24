package school.faang.BJS2_38714_PumpingAlchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int INGREDIENT_GATHER_TIME = 1_000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredientsCount = new AtomicInteger();

        CompletableFuture<?>[] futureResults =
                potions.stream()
                        .map(potion -> gatherIngredients(potion)
                                .thenAccept(totalIngredientsCount::addAndGet)
                        )
                        .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futureResults)
                .thenRun(() -> log.info("Total ingredients count: {}", totalIngredientsCount.get()))
                .join();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Started gathering ingredients for {}", potion.getName());
            try {
                Thread.sleep((long) INGREDIENT_GATHER_TIME * potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                log.error(
                        "Thread {} was interrupted while gathering ingredients for {}",
                        Thread.currentThread().getName(), potion.getName(),
                        e
                );
            }
            log.info("Finished gathering ingredients for {}", potion.getName());
            return potion.getRequiredIngredients();
        });
    }
}
