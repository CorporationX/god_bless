package school.faang.bjs2_38826;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class IngredientsCollector {

    public static List<CompletableFuture<Integer>> gatherIngredients(List<Potion> potions) {
        return potions.stream()
                .map(IngredientsCollector::assembly)
                .toList();
    }

    public static int totalIngredients(List<CompletableFuture<Integer>> futures) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));

        return totalIngredients.get();
    }

    private static CompletableFuture<Integer> assembly(Potion potion) {
        int collectionTime = 1_000  * potion.getRequiredIngredients();

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(collectionTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(String.format("For potion %s ingredients collected: %d", potion.getName(), potion.getRequiredIngredients()));

            return potion.getRequiredIngredients();
        });
    }
}
