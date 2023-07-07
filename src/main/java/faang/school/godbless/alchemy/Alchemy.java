package faang.school.godbless.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Alchemy {
    public static void main(String[] args) {
        Alchemy alchemy = new Alchemy();

        List<Potion> potions = List.of(
            new Potion("potion 1", 3),
            new Potion("potion 2", 4),
            new Potion("potion 3", 6),
            new Potion("potion 4", 2),
            new Potion("potion 5", 5)
        );

        List<CompletableFuture<Integer>> actionsList = potions.stream().map((alchemy::gatherIngredients)).toList();

        AtomicInteger totalCount = new AtomicInteger();

        CompletableFuture.allOf(actionsList.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    potions.forEach((potion) -> {
                        totalCount.addAndGet(potion.getRequiredIngredients());
                    });
                })
                .join();

        System.out.println(totalCount);
    }

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Collecting ingredients for " + potion.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * potion.getRequiredIngredients());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Ingredients for " + potion.getName() + " were collected");

            return potion.getRequiredIngredients();
        }, executorService);
    }
}
