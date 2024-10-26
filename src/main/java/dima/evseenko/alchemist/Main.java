package dima.evseenko.alchemist;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        gatherAllIngredients(getPotions());
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<CompletableFuture<Integer>> futures = potions.stream().map((potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executorService))).toList();

        executorService.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenAccept((Void aVoid) -> {
            System.out.println(futures.stream().mapToInt(CompletableFuture::join).sum());
        });
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(new Random().nextInt(3000 - 1000) + 1000);
            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Ошибка сбора ингредиентов для %s".formatted(potion.getName()), e);
        }
    }

    private static List<Potion> getPotions() {
        return List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
    }
}
