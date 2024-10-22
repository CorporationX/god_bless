package school.faang.improve_alchemy_BJS2_38674;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

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
        ExecutorService executor = Executors.newCachedThreadPool();

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(potion::gatherIngredients, executor))
                .toList();
        executor.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(() -> {
            AtomicInteger counterIngredients = new AtomicInteger(0);
            futures.forEach(future ->
                    counterIngredients.addAndGet(future.join()));
            System.out.println("Total ingredients gathered: " + counterIngredients);
        });
    }
}