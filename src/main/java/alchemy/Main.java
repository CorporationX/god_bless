package alchemy;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final long INGREDIENT_GATHER = 500L;

    public static void main(String[] args) throws InterruptedException {
        var potions = initPotions();
        try (ExecutorService executor = Executors.newFixedThreadPool(potions.size())) {
            var futuresList = potions.stream()
                    .map(p -> CompletableFuture.supplyAsync(() -> gatherIngredients(p), executor))
                    .toList();
            AtomicInteger sumOfAllIngredient = new AtomicInteger(0);
            CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]))
                    .thenRunAsync(() -> futuresList.forEach(r -> sumOfAllIngredient.getAndAdd(r.join())), executor)
                    .join();
            log.info("Total ingredients collected: " + sumOfAllIngredient.get());
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Finished!");
            } else {
                log.error("Time out");
            }
        }
    }

    private static List<Potion> initPotions() {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Health potion", 2));
        potions.add(new Potion("Big health potion", 3));
        potions.add(new Potion("Invisibility potion", 3));
        potions.add(new Potion("Regeneration potion", 2));
        potions.add(new Potion("Mana potion", 2));
        potions.add(new Potion("Stamina potion", 2));
        potions.add(new Potion("Strength potion", 3));
        return potions;
    }

    private static int gatherIngredients(@NonNull Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * INGREDIENT_GATHER);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info(String.format("Gathered %d ingredients for %s", potion.getRequiredIngredients(), potion.getName()));
        return potion.getRequiredIngredients();
    }
}
