package faang.school.godbless.BJS2_1341;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class Main {
    public static AtomicInteger totalIngredients = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 3),
                new Potion("Invisibility Potion", 5),
                new Potion("Strength Potion", 4)
        );

        ExecutorService executor = Executors.newFixedThreadPool(potions.size());

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(getPotionCompletableFutureFunction())
                .toList();

        try {
            CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        } finally {
            executor.shutdown();
        }
        System.out.println(Thread.currentThread() + "Total ingredients gathered: " + totalIngredients);
    }

    private static Function<Potion, CompletableFuture<Integer>> getPotionCompletableFutureFunction() {
        return potion -> CompletableFuture.supplyAsync(() -> totalIngredients.addAndGet(gatherIngredients(potion)));
    }

    public static int gatherIngredients(Potion potion) {
        System.out.println(Thread.currentThread() + " Ingredient gathering has begun for " + potion.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread() + "Ingredients gathered for " + potion.getName() + ": " + potion.getRequiredIngredients());
        return potion.getRequiredIngredients();
    }
}