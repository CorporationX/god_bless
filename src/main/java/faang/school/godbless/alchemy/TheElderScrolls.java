package faang.school.godbless.alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class TheElderScrolls {
    private AtomicInteger totalInteger = new AtomicInteger(0);
    public CompletableFuture<Integer> gatherIngredients(Potion potion){
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("The gathering for %s is started!\n", potion.getName());
            try {
                Thread.sleep(potion.getRequiredIngredients() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalInteger.addAndGet(potion.getRequiredIngredients());
            System.out.printf("The gathering for %s is finished\n", potion.getName());
            return potion.getRequiredIngredients();
        });
    }

    public AtomicInteger getTotalInteger() {
        return totalInteger;
    }

    public static void main(String[] args) {
        TheElderScrolls theElderScrolls = new TheElderScrolls();
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Health Potion", 3));
        potions.add(new Potion("Mana Potion", 5));
        potions.add(new Potion("Strength Potion", 10));
        potions.add(new Potion("Speed Potion", 7));
        potions.add(new Potion("Invisibility Potion", 2));
        potions.add(new Potion("Fire Resistance Potion", 4));
        potions.add(new Potion("Water Breathing Potion", 6));
        potions.add(new Potion("Jump Boost Potion", 8));
        potions.add(new Potion("Night Vision Potion", 3));
        potions.add(new Potion("Regeneration Potion", 5));
        potions.add(new Potion("Luck Potion", 1));
        potions.add(new Potion("Poison Potion", 4));
        potions.add(new Potion("Weakness Potion", 2));


        List<CompletableFuture<Integer>> futurePotions = potions.stream()
                .map(theElderScrolls::gatherIngredients)
                .toList();
        try {
            CompletableFuture.allOf(futurePotions.toArray(CompletableFuture[]::new)).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The total amount of ingredients needed is " + theElderScrolls.getTotalInteger());

    }
}
