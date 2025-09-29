package school.faang.bjs294920;

import java.util.List;
import java.util.concurrent.CompletableFuture;
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

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
            .map(potion -> gatherIngredients(potion))
            .toList();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        futures.forEach(future -> future.thenAccept(totalIngredients::addAndGet));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total ingredients gathered: " + totalIngredients.get());
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Finished gathering ingredients for " + potion.getName());
                return potion.getIngridients();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
    }
}

