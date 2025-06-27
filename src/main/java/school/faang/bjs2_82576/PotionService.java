package school.faang.bjs2_82576;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class PotionService {
    private static final int ONE_SECOND_IN_MS = 1000;
    private final ExecutorService executor;

    public PotionService(ExecutorService executor) {
        this.executor = executor;
    }

    public CompletableFuture<Integer> collectIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) potion.getIngredients() * ONE_SECOND_IN_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return potion.getIngredients();
        }, executor);
    }
}
