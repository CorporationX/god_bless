package school.faang.task_50912;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public record Potion(String name, int requiredIngredients) {
    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potion.requiredIngredients();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        allOf.thenRun(() -> {
            futures.forEach(future -> totalIngredients.addAndGet(future.join()));
            System.out.println("Total ingredients gathered: " + totalIngredients.get());
        }).join();
    }
}