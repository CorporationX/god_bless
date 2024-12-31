package school.faang.bjs250902;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Gathering {

    private static final long GATHERING_TIME = 3000L;

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("The gathering of ingredients has begun");

            try {
                Thread.sleep(GATHERING_TIME);
            } catch (InterruptedException e) {
                log.error("The tread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }

            return potion.requiredIngredients();
        });
    }
}