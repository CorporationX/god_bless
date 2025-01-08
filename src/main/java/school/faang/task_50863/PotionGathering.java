package school.faang.task_50863;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int DELAY = 30;

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            throw new CompletionException(e);
        }

        return potion.getRequiredIngredients();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService executor = Executors.newFixedThreadPool(potions.size());

        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> allIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor)
                                .thenApply(totalIngredients::addAndGet))
                .toList();

        CompletableFuture.allOf(allIngredients.toArray(new CompletableFuture[0])).join();

        int total = totalIngredients.get();
        System.out.println("Общее количество собранных ингредиентов: " + total);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(DELAY, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }
}
