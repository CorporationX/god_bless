package school.faang.task_62516;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        AtomicInteger totalIngredients = new AtomicInteger(0);
        allOf.thenRun(() -> {
            futures.forEach(future -> future.thenAccept(totalIngredients::addAndGet));
            log.info("Total amount of collected ingredients: {}", totalIngredients.get());
        }).join();
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Starting process of gathering ingredients for {}", potion.getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info("Ingredients for {} have been collected.", potion.getName());
            return potion.getRequiredIngredients();
        });
    }
}
