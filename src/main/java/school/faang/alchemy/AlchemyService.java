package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class AlchemyService {
    private static final int GATHER_TIME_MS = 1000;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GATHER_TIME_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Collected for: {} - {} ", potion.getName(), potion.getRequiredIngredients());
            return potion.getRequiredIngredients();
        });
    }
}
