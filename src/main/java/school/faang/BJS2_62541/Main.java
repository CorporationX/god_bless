package school.faang.BJS2_62541;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        IngredientGatherer ig = new IngredientGatherer();

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> ig.gatherIngredients(potion)))
                .toList();

        int result = CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .mapToInt(CompletableFuture::join)
                        .sum()
                ).join();

        System.out.println(result);
    }
}
