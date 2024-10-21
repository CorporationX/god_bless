package school.BJS2_38677;

import java.util.ArrayList;
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

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        ExecutorService service = Executors.newFixedThreadPool(potions.size());
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        potions.stream().forEach(potion ->
                futures.add(CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                            return potion.getRequiredIngredients();
                        }, service)
                ));
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(() -> {
            AtomicInteger totalIngredients = new AtomicInteger(0);
            futures.forEach(future -> {
                totalIngredients.addAndGet(future.join());
            });
            System.out.println("Итоговая сумма ингрeдиентов: " + totalIngredients);
        });
        service.shutdown();
    }
}
