package school.faang.bjs251106;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {

    private static final int TWO_SECOND = 2000;

    private CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TWO_SECOND);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted", e);
            }
            return potion.requiredIngredients();
        });
    }

    public void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                potions.stream()
                        .map(potion -> gatherIngredients(potion)
                                .thenAccept(totalIngredients::addAndGet))
                        .toArray(CompletableFuture[]::new)
        );

        allFutures.join();

        log.info("Total ingredients: {}", totalIngredients.get());
    }
}
