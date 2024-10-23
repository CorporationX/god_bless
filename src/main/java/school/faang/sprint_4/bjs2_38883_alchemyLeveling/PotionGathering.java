package school.faang.sprint_4.bjs2_38883_alchemyLeveling;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int THREADS_COUNT = 5;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        PotionGathering potionGathering = new PotionGathering();
        List<Potion> potions = List.of(new Potion("Strength Potion", 6),
                new Potion("Agility Potion", 2),
                new Potion("Intelligence Potion", 8),
                new Potion("Vitality Potion", 4),
                new Potion("Shield Potion", 5),
                new Potion("Regeneration Potion", 7),
                new Potion("Speed Potion", 3),
                new Potion("Accuracy Potion", 9),
                new Potion("Luck Potion", 1),
                new Potion("Endurance Potion", 6)
        );

        potionGathering.gatherAllIngredients(potions);
    }

    private int gatherIngredients(Potion potion) {
        String name = potion.getName();
        int ingredientsCount = potion.getIngredientsCount();

        try {
            log.info("Gathering ingredients for {}, it will take {} seconds.", name, ingredientsCount);
            Thread.sleep(ingredientsCount * 1000L);
        } catch (InterruptedException e) {
            log.error("An error occurred while ingredients gathering.", e);
            throw new IllegalStateException(e);
        }
        return ingredientsCount;
    }

    private void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger ingredientsSum = new AtomicInteger();

        List<CompletableFuture<Integer>> futureCounts = potions.stream()
                .map(potion ->
                        CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor))
                .toList();

        CompletableFuture.allOf(futureCounts.toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        futureCounts.forEach(futureCount ->
                                ingredientsSum.getAndAdd(futureCount.join())))
                .thenRun(() ->
                        log.info("For all potions {} ingredients were collected.", ingredientsSum.get()))
                .join();

        finishGathering();
    }

    private void finishGathering() {
        log.info("Gathering is over!");
        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Something went wrong! Shutting down now!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while thread shutting down now.", e);
            throw new IllegalStateException(e);
        }
    }
}