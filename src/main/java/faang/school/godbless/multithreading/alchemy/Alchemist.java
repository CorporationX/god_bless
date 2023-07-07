package faang.school.godbless.multithreading.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Alchemist {
    private final AtomicInteger totalIngredients;
    private final AtomicInteger totalIngredientsAnother;

    public Alchemist() {
        totalIngredients = new AtomicInteger(0);
        totalIngredientsAnother = new AtomicInteger(0);
    }

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return potion.getRequiredIngredients();
        });
    }

    public void brewPotions(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions
                .stream()
                .map(this::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    for (CompletableFuture<Integer> potion : futures) {
                        try {
                            totalIngredients.addAndGet(potion.get());
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(totalIngredients.get());
                })
                .join();
    }

    // Подумал, что так логичнее было бы реализовать, но по условию, как понял, вроде первый вариант требовался
    public CompletableFuture<Void> gatherIngredientsAnother(Potion potion) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalIngredientsAnother.addAndGet(potion.getRequiredIngredients());
        });
    }

    public void brewPotionsAnother(List<Potion> potions) {
        List<CompletableFuture<Void>> futures = potions
                .stream()
                .map(this::gatherIngredientsAnother)
                .toList();

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println(totalIngredientsAnother.get()))
                .join();
    }
}
