package school.faang.bjs2_62440;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(
                        () -> IngredientGatheringService.gatherIngredients(potion)))
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(f -> totalIngredients.addAndGet(f.join())))
                .join();
        log.info("Total ingredients gathered: {}", totalIngredients.get());
    }
}