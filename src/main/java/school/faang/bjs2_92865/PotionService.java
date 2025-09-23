package school.faang.bjs2_92865;

import java.util.concurrent.CompletableFuture;

public class PotionService {
    private static final int DEFAULT_SLEEP = 1000;

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            sleepThread(DEFAULT_SLEEP * potion.getRequiredIngredients());
            return potion.getRequiredIngredients();
        });
    }

    private void sleepThread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
