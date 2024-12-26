package school.faang.task_51115;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PotionGathering {
    private static final long SLEEP_TIME = 1000;

    public int gatherIngredients(List<Potion> potions) {
        return potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(potion.getRequiredIngredients() * PotionGathering.SLEEP_TIME);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return potion.getRequiredIngredients();
                }))
                .mapToInt(CompletableFuture::join)
                .sum();
    }

}


