package school.faang.bjs2_92859;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {
    private static IngredientsService service = new IngredientsService();

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
                .map(potion -> CompletableFuture.supplyAsync(() ->
                        service.gatherIngredients(potion)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(future ->
                        System.out.println("Collected: " + future.join())))
                .join();
    }
}
