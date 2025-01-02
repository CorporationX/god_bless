package derschrank.sprint04.task04.bjstwo_50932;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PotionService {
    public static final int DEFAULT_DELAY = 1000;

    public int gatherIngredients(Potion potion) {
        System.out.println(" + Begin gathering ingredients for: " + potion.name());

        int ingredients = potion.requiredIngredients();
        toSleep(DEFAULT_DELAY * ingredients);

        System.out.println(" - End gathering ingredients for: " + potion.name());
        return ingredients;
    }

    public int gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(
                        () -> gatherIngredients(potion)
                ))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return futures.stream().mapToInt(CompletableFuture::join).sum();
    }

    private void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("PotionService Was interrupted: {}", String.valueOf(e));
        }
    }
}
