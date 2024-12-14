package school.faang.task414.potion;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotionGathering {
    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(potion::gatherIngredients))
                .toList();
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        completableFuture.join();

        AtomicInteger totalIngredients = new AtomicInteger(0);

        completableFutures.forEach(future -> totalIngredients.addAndGet(future.join()));
        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    }
}
