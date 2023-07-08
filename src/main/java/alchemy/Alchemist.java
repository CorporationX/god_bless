package alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Alchemist {
    public static void main(String[] args) {
        PotionList potionList = new PotionList();
        potionList.addPotion(new Potion("Courage", 5));
        potionList.addPotion(new Potion("Intelligence", 7));
        potionList.addPotion(new Potion("Kindness", 4));
        potionList.addPotion(new Potion("Salary Increase", 6));
        potionList.addPotion(new Potion("Health", 5));
        potionList.addPotion(new Potion("Happiness", 6));

        List<CompletableFuture<Integer>> futureList = potionList.getPotionList().stream()
                .map(potionList::gatherIngredients)
                .toList();

        AtomicInteger totalIngredients = new AtomicInteger();

        CompletableFuture.allOf(futureList.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                            for (CompletableFuture<Integer> ingredientFuture : futureList) {
                                totalIngredients.addAndGet(ingredientFuture.join());
                            }
                            System.out.println("Number of ingredients for all potions: " + totalIngredients.get());
                        }
                ).join();
    }
}