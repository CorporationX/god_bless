package improving_alchemistry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Damage Potion", 5),
                new Potion("Healing Potion", 2),
                new Potion("Frozen Potion", 3)
        );
        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .toList();
        CompletableFuture<Void> allIngredients =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                        .thenRun(() -> futures.forEach(f -> totalIngredients.addAndGet(f.join())));
        allIngredients.join();
        System.out.println("Всего собрано ингредиентов: " + totalIngredients);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            int requiredIngredients = potion.getRequiredIngredients();
            try {
                Thread.sleep(requiredIngredients * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return requiredIngredients;
        });
    }
}
