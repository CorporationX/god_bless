package school.faang.task_62493;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion.getRequiredIngredients())
                        .thenAccept(x -> atomicInteger.addAndGet(x)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Общее количество собранных ингредиентов: " + atomicInteger.get()));
    }
}
