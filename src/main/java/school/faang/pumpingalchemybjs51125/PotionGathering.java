package school.faang.pumpingalchemybjs51125;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    private static final Logger logger = LoggerFactory.getLogger(PotionGathering.class);
    private static final int COLLECTION_TIME_INGREDIENTS = 1000;

    public static final int HEALING_POTION = 5;
    public static final int MANA_POTION = 3;
    public static final int STAMINA_POTION = 4;

    public static final int INITIAL_TOTAL_INGREDIENTS = 0;
    public static final int COMPLETABLE_FUTURE_ARRAY_SIZE = 0;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                logger.info("The collection of ingredients for: " + potion.getName());
                Thread.sleep(COLLECTION_TIME_INGREDIENTS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("The collection of ingredients has been interrupted", e);
                throw new RuntimeException(e);
            }
            logger.info("Collected {} ingredients for: {}", potion.getRequiredIngredients(),
                    potion.getName());
            return potion.getRequiredIngredients();
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(
                new CompletableFuture[COMPLETABLE_FUTURE_ARRAY_SIZE]));

        allOf.thenAccept(v -> {
            AtomicInteger totalIngredients = new AtomicInteger(INITIAL_TOTAL_INGREDIENTS);
            futures.forEach(future -> {
                try {
                    totalIngredients.addAndGet(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Error when getting the result of collecting ingredients", e);
                }
            });
            logger.info("Total number of ingredients collected: {}", totalIngredients.get());
        });
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing potion", HEALING_POTION),
                new Potion("Mana potion", MANA_POTION),
                new Potion("Stamina potion", STAMINA_POTION)
        );
        gatherAllIngredients(potions);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Main thread interrupted", e);
        }
    }
}
