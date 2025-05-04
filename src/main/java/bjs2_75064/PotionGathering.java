package bjs2_75064;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    public static CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        }, executor);
    }

    public static int gatherAllIngredients(List<Potion> ingredients, ExecutorService executor) {
        AtomicInteger numberOfAllIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> tasks = ingredients.stream()
                .map(ingredient -> gatherIngredients(ingredient, executor)
                        .thenAccept(numberOfAllIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        allTasks.join();
        return numberOfAllIngredients.get();
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);

        log.info("Total number of ingredients collected: {}", gatherAllIngredients(potions, executor));

        executor.shutdown();
    }
}
