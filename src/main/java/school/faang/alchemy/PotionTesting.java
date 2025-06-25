package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionTesting {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futureList = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion.collectingIngredients()))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        allFutures.join();
        int total = futureList.stream()
                .mapToInt(future -> future.join())
                .sum();

        log.info("Общее количество собранных ингредиентов: {}", total);
    }
}
