package school.faang.boost_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PotionMaker {
    private static final long THREAD_SLEEP_TIME = 1000L;

    private CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) (THREAD_SLEEP_TIME * Math.random() + 0.1));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread {} error", Thread.currentThread().getName());
            }
            return potion.getRequiredIngredients();
        });
    }

    public List<CompletableFuture<Integer>> gatherAllIngredients(List<Potion> potions) {
        return potions.stream()
                .map(potion -> gatherIngredients(potion))
                .toList();
    }
}
