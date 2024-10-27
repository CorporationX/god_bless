package school.faang.improve;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        List<Hero> heroes = List.of(
                new Hero(new Random(), "Drago"),
                new Hero(new Random(), "Rocky"),
                new Hero(new Random(), "Apollo")
        );

        ExecutorService executor = Executors.newFixedThreadPool(potions.size());
        AtomicInteger collectedIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream().map(potion -> {
            Hero hero = heroes.get(new Random().nextInt(heroes.size()));
            return CompletableFuture.runAsync(() -> {
                int ingredients = hero.gatherIngredients(potion);
                collectedIngredients.addAndGet(ingredients);
            }, executor);
        }).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Collected ingredients: {}", collectedIngredients);

        closeExecutor(executor);
    }

    private static void closeExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}