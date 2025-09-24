package school.faang.bjs2_92865;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class PotionService {
    private static final int DEFAULT_SLEEP = 1000;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            sleepThread(DEFAULT_SLEEP * potion.getRequiredIngredients());
            increment(potion.getRequiredIngredients());
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

    private void increment(int delta) {
        atomicInteger.addAndGet(delta);
    }
}
