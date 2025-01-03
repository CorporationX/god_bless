package school.faang.bjs251106;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {

    private static final int TWO_SECOND = 2000;

    private CompletableFuture<Integer> gatherIngredients(Potion potions) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TWO_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted", e);
            }
            return potions.getRequiredIngredients();
        });
    }

    public void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(this::gatherIngredients)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        AtomicInteger totalIngredients = new AtomicInteger(0);

        allFutures.join();
        futures.forEach(future -> totalIngredients.addAndGet(future.join()));

        log.info("Total ingredients: {}", totalIngredients.get());
    }
}
