package school.faang.task_51065;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {

    public static void gatherAllIngredients(List<Potion> potions) {

        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(potion::gatherIngredients)
                        .thenAccept(totalIngredients::addAndGet))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total ingredients gathered: " + totalIngredients);
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);

    }
}
