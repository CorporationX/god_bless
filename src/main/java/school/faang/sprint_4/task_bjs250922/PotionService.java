package school.faang.sprint_4.task_bjs250922;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class PotionService {
    private static final long MILLIS_GATHERING_TIME = 2000L;

    public CompletableFuture<Integer> gatherPotionIngredientsFuture(Potion potion, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            emulateWork();
            return potion.requiredIngredients();
        }, executor);
    }

    public List<CompletableFuture<Integer>> gatherPotionIngredientsFuture(
            List<Potion> potions, ExecutorService executor) {
        return potions.stream()
                .map(potion -> gatherPotionIngredientsFuture(potion, executor))
                .toList();
    }

    private static void emulateWork() {
        try {
            Thread.sleep(MILLIS_GATHERING_TIME);
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
