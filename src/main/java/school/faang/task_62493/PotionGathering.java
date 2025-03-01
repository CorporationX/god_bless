package school.faang.task_62493;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int TIME_MILISECONDS = 1000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(TIME_MILISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван: {}", e.getMessage(), e);
                throw new RuntimeException("Поток был прерван: " + e.getMessage(), e);
            }
            return potion.requiredIngredients();
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion.requiredIngredients())
                        .thenAccept(x -> atomicInteger.addAndGet(x)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Общее количество собранных ингредиентов: " + atomicInteger.get()));
    }
}
