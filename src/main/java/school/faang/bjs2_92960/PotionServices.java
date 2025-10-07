package school.faang.bjs2_92960;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class PotionServices {
    private static final long BASIC_DURATION = 2_000;
    private final AtomicInteger atomInt = new AtomicInteger();


    public CompletableFuture<Void> gatherIngredient(Potion potion) {
        return CompletableFuture
                .supplyAsync(() -> {
                    log.info("Starting to gather ingredients for {}", potion.getName());
                    gatherImitation(BASIC_DURATION * potion.getRequiredCount());
                    log.info("{} callback 1", Thread.currentThread().getName());
                    return potion.getRequiredCount();
                })
                .thenApplyAsync((ingredientsCount -> {
                    log.info("{} callback 2", Thread.currentThread().getName());

                    return ingredientsCount;
                }))
                .thenAcceptAsync((ingredientsCount -> {
                    increment(ingredientsCount);
                    log.info("{} callback 3", Thread.currentThread().getName());
                }));
    }

    private void gatherImitation(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void increment(int delta) {
        atomInt.addAndGet(delta);
    }
}
