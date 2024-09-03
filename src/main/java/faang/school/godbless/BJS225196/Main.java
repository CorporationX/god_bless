package faang.school.godbless.BJS225196;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final long INGREDIENT_GATHER = 500L;

    public static void main(String[] args) {
        var potions = initPotions();
        var futuresList = potions.stream()
                .map(Main::gatherIngredients)
                .toList();
        AtomicInteger sumOfAllIngredient = new AtomicInteger(0);
        CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]))
                .thenRunAsync(() -> futuresList.forEach(r -> sumOfAllIngredient.getAndAdd(r.join())))
                .join();
        log.info("Total ingredients collected: " + sumOfAllIngredient.get());
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

    private static CompletableFuture<Integer> gatherIngredients(@NonNull Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * INGREDIENT_GATHER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info(String.format("Gathered %d ingredients for %s", potion.getRequiredIngredients(), potion.getName()));
            return potion.getRequiredIngredients();
        });
    }
}
