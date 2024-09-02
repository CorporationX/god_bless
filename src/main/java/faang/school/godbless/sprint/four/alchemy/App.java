package faang.school.godbless.sprint.four.alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String... args) {
        List<Potion> potions = new ArrayList<>(List.of(
                new Potion("Elixir of Vitality"),
                new Potion("Potion of Healing"),
                new Potion("Mana Tonic"),
                new Potion("Essence of Speed")
        ));

        CollectPotionService collectPotionService = new CollectPotionService();

        List<CompletableFuture<Integer>> processedPortions = potions.stream()
                .map(collectPotionService::gatherIngredients)
                .toList();

        int allIngredients = CompletableFuture.allOf(
                processedPortions.toArray(new CompletableFuture[0])
        ).thenApply(v -> collectPotionService.getCommonPotionAmount().get()).join();

        System.out.printf("All ingredients %d%n", allIngredients);
    }
}
