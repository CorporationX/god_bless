package faang.school.godbless.multi_asyn.task5alchemistry;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<Potion> potions = Arrays.asList(
                new Potion("Healing Potion", 3),
                new Potion("Invisibility Potion", 4),
                new Potion("Strength Potion", 2)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() ->
                futures.forEach(future -> totalIngredients.addAndGet(future.join()))
        ).join();

        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return potion.getRequiredIngredients();
    }
}
