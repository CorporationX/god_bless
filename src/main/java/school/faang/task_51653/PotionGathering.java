package school.faang.task_51653;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    public static int gatherIngredients(Potion potion) {
        try {
            System.out.println("Gathering ingredients for " + potion.getName());
            Thread.sleep(potion.getRequiredIngredients() * 1000L);
            System.out.println("Finished gathering for " + potion.getName());
            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> {
            int totalIngredients = futures.stream()
                    .mapToInt(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    })
                    .sum();
            System.out.println("Общее количество собранных ингредиентов: " + totalIngredients);
        }).join();
    }
}