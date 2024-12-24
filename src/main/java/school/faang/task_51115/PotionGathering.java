package school.faang.task_51115;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class PotionGathering {
    private static final long SLEEP_TIME = 1000;

    public int gatherIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    setSleepTime(potion);
                    return potion.getRequiredIngredients();
                })).toList();
        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allDone.join();

        return futures.stream()
                .mapToInt((future) -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();
    }

    private void setSleepTime(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * PotionGathering.SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


