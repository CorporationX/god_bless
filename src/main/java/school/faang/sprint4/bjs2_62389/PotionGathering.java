package school.faang.sprint4.bjs2_62389;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {

    public static CompletableFuture<Integer> gatherIngredients(@NonNull Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return potion.getRequiredIngredients();
        });
    }

    public static void gatherAllIngredients(@NonNull List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        AtomicInteger totalIngredients = new AtomicInteger(0);

        allFutures.thenRun(() -> {
            for (CompletableFuture<Integer> future : futures) {
                totalIngredients.addAndGet(future.join());
            }
            System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
        }).join();
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
