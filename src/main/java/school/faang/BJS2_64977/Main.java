package school.faang.BJS2_64977;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        AtomicInteger totalIngredients = new AtomicInteger();

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> Potion.requiredIngredients(potion))
                        .thenApply(ingredients -> {
                            totalIngredients.addAndGet(ingredients);
                            return ingredients;
                        }))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.printf("%nВсего собрано ингредиентов: %d%n", totalIngredients.get());
    }
}
