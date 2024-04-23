package faang.school.godbless.ImprovingAlchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int NUM_THREAD = 5;

    public static void main(String[] args) {
        List<Potion> potions = getPotions();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREAD);

        AtomicInteger ingredientSum = new AtomicInteger(0);
        List<CompletableFuture<Integer>> ingredientsGathering = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), pool).thenApply(ingredientSum::addAndGet))
                .toList();
        pool.shutdown();
        CompletableFuture.allOf(ingredientsGathering.toArray(CompletableFuture[]::new)).join();

        System.out.println("total ingredients: " + ingredientSum.get());
    }

    private static List<Potion> getPotions() {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Potion of Luck", 3));
        potions.add(new Potion("Polyjuice Potion", 12));
        potions.add(new Potion("Veritaserum", 4));
        potions.add(new Potion("Potion of Living Death", 10));
        potions.add(new Potion("Pepper Up Potion", 2));
        return potions;
    }

    private static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
