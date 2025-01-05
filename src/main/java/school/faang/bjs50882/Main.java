package school.faang.bjs50882;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static final long INGREDIENT_SEARCH_TIME = 1000;

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Poison", 3));
        potions.add(new Potion("Healing Potion", 5));
        potions.add(new Potion("Mana Potion", 4));
        potions.add(new Potion("Invisibility Potion", 6));

        var potionsFuture = new ArrayList<CompletableFuture<Potion>>();

        potions.forEach(potion -> potionsFuture.add(gatherIngredients(potion)));

        var potionFinished = CompletableFuture.allOf(potionsFuture.toArray(new CompletableFuture[0]));
        potionFinished.join();
        potionFinished.thenRun(() -> log.info("Total ingredients collected: {}",
                potionsFuture.stream()
                        .map(potionFuture -> {
                            try {
                                return potionFuture.get().getIngredientNumber();
                            } catch (Exception e) {
                                return 0;
                            }
                        })
                        .reduce(0, Integer::sum)));
    }

    public static CompletableFuture<Potion> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            for (int i = 1; i <= potion.getIngredientNumber(); i++) {
                try {
                    Thread.sleep(INGREDIENT_SEARCH_TIME);
                } catch (InterruptedException e) {
                    log.info("Error while collecting ingredients for {}", potion.getName());
                }
            }
            return potion;
        });
    }
}
