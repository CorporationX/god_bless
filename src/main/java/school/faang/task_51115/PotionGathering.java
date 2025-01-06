package school.faang.task_51115;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final long SLEEP_TIME = 1000;
    private final AtomicInteger totalIngredients = new AtomicInteger(0);

    public int gatherIngredients(List<Potion> potions) {
        List<CompletableFuture<Void>> listOfPotion = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(potion.getRequiredIngredients() * PotionGathering.SLEEP_TIME);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return potion.getRequiredIngredients();
                }).thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(listOfPotion.toArray(new CompletableFuture[0]));
        allOf.join();

        return totalIngredients.get();

    }

}


