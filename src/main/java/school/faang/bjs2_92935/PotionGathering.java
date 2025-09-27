package school.faang.bjs2_92935;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int TIME_SLEEP = 500;

    public static int gatherIngredients(Potion potion) {
        try {
            log.info("Collecting Potion ingredients: {} - {}", potion.name, potion.requiredIngredients);
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return potion.requiredIngredients;
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenAccept(ingredients -> totalIngredients.addAndGet(ingredients)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total number of ingredients collected: " + totalIngredients.get());
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