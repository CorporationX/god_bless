package school.faang.bjs2_82576;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PotionService {
    private static final int ONE_SECOND_IN_MS = 1000;

    ExecutorService executor = Executors.newFixedThreadPool(4);

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

    public void shutdown() {
        executor.shutdown();
    }
}
