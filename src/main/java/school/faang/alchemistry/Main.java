package school.faang.alchemistry;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GatherIngredients gatherIngredients = new GatherIngredients();
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients.gatherIngredients(potion)))
                .toList();

        completableFutures.forEach(completableFuture -> {
            try {
                completableFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Error!!!", e);
            }
        });

        AtomicInteger totalIngredients = new AtomicInteger(0);

        completableFutures.forEach(future -> {
            try {
                totalIngredients.addAndGet(future.get());
            } catch (InterruptedException | ExecutionException e) {
                log.error("Error!", e);
            }
        });
        log.debug("Total ingredients number: {}", totalIngredients.get());
    }
}
