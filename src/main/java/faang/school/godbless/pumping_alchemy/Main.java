package faang.school.godbless.pumping_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final long NEEDED_TIME_PER_INGREDIENT = 1000L;
    private static final AtomicInteger ingredientCollector = new AtomicInteger();

    public static void main(String[] args) {
        List<Potion> potionList = getPotionList();

        List<CompletableFuture<Void>> futureIngredients = potionList.stream()
                .map(potion -> gatherIngredients(potion).thenAccept(ingredientCollector::addAndGet))
                .toList();

        CompletableFuture<Void> allOfFutureIngredients = CompletableFuture.allOf(
                futureIngredients.toArray(CompletableFuture[]::new));

        allOfFutureIngredients.thenRun(() -> System.out.println("Total ingredients: " + ingredientCollector.get()))
                .join();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info(Thread.currentThread().getName() + " started ingredient collection");
            int neededIngredients = potion.requiredIngredients();

            try {
                Thread.sleep(neededIngredients * NEEDED_TIME_PER_INGREDIENT);
            } catch (InterruptedException e) {
                throw new RuntimeException("Was interrupted during ingredient collection: " + e.getMessage());
            }

            log.info(Thread.currentThread().getName() + " collected: " + neededIngredients + " ingredients");
            return neededIngredients;
        });
    }

    private static List<Potion> getPotionList() {
        return List.of(
                new Potion("Potion of Strength", 5),
                new Potion("Potion of Regeneration", 7),
                new Potion("Potion of Fire Resistance", 8),
                new Potion("Potion of Swiftness", 10)
        );
    }
}
