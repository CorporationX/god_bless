package faang.school.godbless.multithreading.alchemy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Alchemist {
    private final AtomicInteger totalIngredients;
    private final AtomicInteger totalIngredientsAnother;

    public Alchemist() {
        totalIngredients = new AtomicInteger(0);
        totalIngredientsAnother = new AtomicInteger(0);
    }


    public static void main(String[] args) {
        Alchemist alchemist = new Alchemist();
        Random random = new Random();

        List<Potion> potions = IntStream.rangeClosed(1, 7)
                .mapToObj(i -> new Potion("Potion " + i, random.nextInt(3, 15)))
                .toList();

        alchemist.brewPotions(potions);

        int expected = potions.stream()
                .mapToInt(Potion::getRequiredIngredients)
                .sum();

        System.out.println(expected);

        alchemist.brewPotionsAnother(potions);
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
