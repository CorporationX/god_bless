package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final AtomicInteger INGREDIENTS = new AtomicInteger(0);
    private static final int TIMEOUT_ONE_SECOND = 1_000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionGathering.gatherAllIngredients(potions);


    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIMEOUT_ONE_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage(), e);
            }
            log.info("{} ingredients  collected {}", potion.getName(), potion.getRequiredIngredients());
            return INGREDIENTS.addAndGet(potion.getRequiredIngredients());

        });
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> allIngredients = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();
        CompletableFuture.allOf(allIngredients.toArray(new CompletableFuture[0])).join();
        log.info("{} ingredients collected", INGREDIENTS.get());

    }
}
