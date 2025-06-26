package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
@Slf4j
public class PotionGathering {

    public static final int ONE_SECOND_IN_NS = 1000;

    public static void main(String[] args) {
        var potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        var totalIngredients = new AtomicInteger(0);
        var futures = potions.stream()
                .map(potion -> gatherIngredients(potion).thenApply(totalIngredients::addAndGet))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Общее количество собранных ингредиентов: {}", totalIngredients.get());
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Собираем ингредиенты для {}", potion.name());
            try {
                Thread.sleep(ONE_SECOND_IN_NS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IngredientsGatherException(potion, e);
            }
            log.info("Собрано {} ингредиентов для {}", potion.ingredientsNumber(), potion.name());
            return potion.ingredientsNumber();
        });
    }
}
