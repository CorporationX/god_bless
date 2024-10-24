package bjs2_37881;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Invisibility", 3),
                new Potion("X-Ray", 2),
                new Potion("Heal", 1),
                new Potion("Mana", 30),
                new Potion("Stamina", 25)
        );

        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> gatheredIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    try {
                        return gatherIngredients(potion);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })).toList();

        CompletableFuture.allOf(gatheredIngredients.toArray(new CompletableFuture[0])).join();

        AtomicInteger allIngredients = new AtomicInteger(0);
        gatheredIngredients.stream()
                .map(CompletableFuture::join)
                .forEach(allIngredients::addAndGet);

        System.out.println(allIngredients + " have been gathered!");
    }

    private static int gatherIngredients(Potion potion) throws InterruptedException {
        long millisToSleep = 1000;
        Thread.sleep(millisToSleep);
        return potion.getRequiredIngredients();
    }
}
