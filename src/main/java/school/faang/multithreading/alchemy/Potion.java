package school.faang.multithreading.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion, ExecutorService pool) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Приступили к сбору ингридиентов для: " + potion.getName());
                Thread.sleep(3000);
                return potion.getRequiredIngredients();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, pool);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService pool = Executors.newFixedThreadPool(potions.size());
        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion, pool))
                .toList();

        futures.forEach(future -> totalIngredients.addAndGet(future.join()));
        pool.shutdown();
        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    }
}
