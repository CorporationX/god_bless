package async.six;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static List<Potion> potions = List.of(
            new Potion("Philter of Strength", 3),
            new Potion("Elixir of Strength", 4),
            new Potion("Conjurer's Potion", 5),
            new Potion("Cure Poison", 2),
            new Potion("Philter of Lockpicking", 3)
    );

    public static void main(String[] args) {

        AtomicInteger ingredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.runAsync(() -> {
                    AtomicInteger ingredient = gatherIngredients(potion);
                    ingredients.addAndGet(ingredient.get());
                }))
                .toList();

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFuture.join();

        System.out.println("Total ingredients: " + ingredients);
    }

    public static AtomicInteger gatherIngredients(Potion potions) {
        CompletableFuture<AtomicInteger> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return new AtomicInteger(potions.getRequiredIngredients());
        });
        return future.join();
    }
}
