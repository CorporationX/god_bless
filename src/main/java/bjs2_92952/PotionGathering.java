package bjs2_92952;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    private static final long MILLIS_IN_SECOND = 1000L;

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Начинается сбор ингредиентов для зелья \"%s\"...%n", potion.getName());
                Thread.sleep(potion.getRequiredIngredients() * MILLIS_IN_SECOND);
                System.out.printf("Собраны ингредиенты для зелья \"%s\" (%d шт.)%n",
                        potion.getName(), potion.getRequiredIngredients());
                return potion.getRequiredIngredients();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Сбор был прерван!", e);
            }
        });
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        all.thenRun(() -> {
            futures.forEach(f -> totalIngredients.addAndGet(f.join()));
            System.out.printf("\nОбщее количество собранных ингредиентов: %d", totalIngredients.get());
        }).join();
    }
}