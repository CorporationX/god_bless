package bjs2_75064;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        CompletableFuture<Integer> gatherIngredientsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
        return gatherIngredientsFuture;
    }

    public static int gatherAllIngredients(List<Potion> ingredients) {
        List<CompletableFuture<Integer>> futures = ingredients.stream()
                .map(potion -> gatherIngredients(potion))
                .toList();
        AtomicInteger numberOfAllIngredients = new AtomicInteger(0);
        futures.forEach(potion -> {
            try {
                numberOfAllIngredients.addAndGet(potion.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        return numberOfAllIngredients.get();
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        log.info("Total number of ingredients collected: {}", gatherAllIngredients(potions));
    }
}
