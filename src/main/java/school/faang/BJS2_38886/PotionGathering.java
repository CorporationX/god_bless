package school.faang.BJS2_38886;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PotionGathering {
    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: собрано %d ингредиентов\n", potion.getName(), potion.getRequiredIngredient());
            return potion.getRequiredIngredient();
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
            .map(PotionGathering::gatherIngredients)
            .collect(Collectors.toList());

        AtomicInteger totalIngredients = new AtomicInteger(0);

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(() -> {
            futures.forEach(future -> totalIngredients.addAndGet(future.join()));
            System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
        }).join();
    }
}
