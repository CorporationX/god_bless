package dima.evseenko.alchemist;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PotionService {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void gatherAllIngredients(List<Potion> potions) {
        if (executor.isShutdown()) {
            executor = Executors.newCachedThreadPool();
        }

        List<CompletableFuture<Integer>> futures = potions.stream().map((potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executor))).toList();

        executor.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenAccept((Void aVoid) -> {
            System.out.println(futures.stream().mapToInt(CompletableFuture::join).sum());
        });
    }

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(new Random().nextInt(3000 - 1000) + 1000);
            return potion.getRequiredIngredients();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Ошибка сбора ингредиентов для %s".formatted(potion.getName()), e);
        }
    }
}
