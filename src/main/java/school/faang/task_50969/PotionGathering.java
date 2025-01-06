package school.faang.task_50969;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
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

    private static void gatherAllIngredients(@NonNull List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        CompletableFuture.allOf(potions.stream()
                .map(potion -> gatherIngredients(potion)
                        .thenAccept(totalIngredients::addAndGet))
                .toArray(CompletableFuture[]::new)
        ).join();
        log.info("Total number of collected ingredients: {}", totalIngredients.get());
    }

    private static CompletableFuture<Integer> gatherIngredients(@NonNull Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread {} was interrupted while processing potion: {}",
                        Thread.currentThread().getName(), potion);
                throw new CompletionException(e);
            }
            return potion.requiredIngredients();
        });
    }

}
