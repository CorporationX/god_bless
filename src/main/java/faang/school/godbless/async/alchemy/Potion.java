package faang.school.godbless.async.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public record Potion(String name, int requiredIngredients) {

    public static final long MAX_BOUND = 10_000L;
    public static final long MIN_BOUND = 1_000L;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService pool) {
        return CompletableFuture.supplyAsync(() -> {
            var randomizer = ThreadLocalRandom.current();

            try {
                Thread.sleep(randomizer.nextLong(MIN_BOUND, MAX_BOUND));
            } catch (InterruptedException e) {
                log.error("Gathering ingredients was interrupted.", e);
            }

            return potion.requiredIngredients;
        }, pool);
    }
}
