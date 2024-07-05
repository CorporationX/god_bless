package faang.school.godbless.async.improving_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int DURATION_GATHERING = 50;
    private static final int POOL_SIZE = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        List<Potion> potions = getPotions();
        log.warn(String.format("All total ingredients: %d", getTotalIngredients(potions)));
    }

    private static int getTotalIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        var futures = CompletableFuture.allOf(
                potions
                        .stream()
                        .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), EXECUTOR)
                                .thenAccept(totalIngredients::addAndGet))
                        .toArray(CompletableFuture[]::new));
        futures.join();
        EXECUTOR.shutdown();
        return totalIngredients.get();
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(potion.requiredIngredients()) * DURATION_GATHERING);
            log.info(String.format("Gathering ingredients for %s collected in count:%d", potion.name(), potion.requiredIngredients()));
        } catch (InterruptedException e) {
            log.warn("Failed to collect ingredients!");
            throw new RuntimeException(e);
        }
        return potion.requiredIngredients();
    }

    private static List<Potion> getPotions() {
        return List.of(
                new Potion("Healing potions", 3),
                new Potion("Intelligence potions", 5),
                new Potion("Strength potions", 6),
                new Potion("Defence potions", 4),
                new Potion("Ability potions", 3));
    }
}
