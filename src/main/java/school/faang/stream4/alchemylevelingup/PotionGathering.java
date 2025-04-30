package school.faang.stream4.alchemylevelingup;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;

@Slf4j
public class PotionGathering {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        System.out.println(gatherAllIngredients(potions));
        endGathering();
    }

    private static int gatherAllIngredients(List<Potion> potions) {

        CompletableFuture<Integer>[] completableFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), SERVICE))
                .toArray((IntFunction<CompletableFuture<Integer>[]>) CompletableFuture[]::new);

        return CompletableFuture.allOf(completableFutures)
                .thenApply(done ->
                        Arrays.stream(completableFutures)
                                .mapToInt(CompletableFuture::join)
                                .sum())
                .join();
    }

    private static int gatherIngredients(Potion potion) {
        log.info("Gathering ingridients for {} started", potion.getName());
        long requiredTime = potion.getRequiredIngredients() * 1500L;
        makeDelayOnGathering(requiredTime);
        log.info("Gathering ingridients for {} is over", potion.getName());
        return potion.getRequiredIngredients();
    }

    private static void makeDelayOnGathering(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("interrupted exception during delay: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static void endGathering() {
        log.info("Gathering is over!");
        int timeout = 30;
        SERVICE.shutdown();
        try {
            if (!SERVICE.awaitTermination(timeout, TimeUnit.SECONDS)) {
                SERVICE.shutdownNow();
            }
        } catch (InterruptedException e) {
            SERVICE.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
