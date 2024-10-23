package school.faang.m1s4.bjs_38657_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PotionGathering {
    private static final int TERMINATION_SECONDS = 20;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService service = Executors.newFixedThreadPool(potions.size());

        int result = potions.stream()
                .map(potion -> {
                    return CompletableFuture
                            .supplyAsync(potion::gatherIngredients, service);
                })
                .toList().stream()
                .mapToInt(CompletableFuture::join)
                .sum();

        shutdownPool(service);
        System.out.printf("%d Total gathered ingredients: %d%n", Thread.currentThread().getId(), result);
    }

    private static void shutdownPool(ExecutorService service) {
        service.shutdown();
        try {
            if (!service.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}


