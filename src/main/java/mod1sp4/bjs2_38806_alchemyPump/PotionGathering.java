package mod1sp4.bjs2_38806_alchemyPump;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {

    private static final AtomicInteger ALL_GATHERING_INGREDIENTS = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
        Potion.shuttingDownExecutor();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Void>> completableFutureElementsInt = potions.stream()
                .map(potion -> potion.gatherIngredients(potion).thenAccept(ALL_GATHERING_INGREDIENTS::addAndGet))
                .toList();

        CompletableFuture.allOf(completableFutureElementsInt.toArray(new CompletableFuture[0])).join();
        log.info("\nОбщее количество собранных ингредиентов: {}", ALL_GATHERING_INGREDIENTS.get());
    }
}
