package school.faang.m1.future.alcohol;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService exec = Executors.newFixedThreadPool(
                Math.min(4, Math.max(1, Runtime.getRuntime().availableProcessors()))
        );

        try {
            AtomicInteger total = new AtomicInteger();
            var futures = potions.stream()
                    .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), exec)
                            .thenAccept(total::addAndGet)).toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(futures).join();
            System.out.println("Total number of collected ingredients: " + total.get());
        } finally {
            exec.shutdown();
        }
    }

    // Асинхронный сбор ингредиентов
    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка при сборе ингредиентов для: " + potion.getName(), e);
        }
        return potion.getRequiredIngredients();
    }
}