package UpgradeAlchemy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger sumIngredients = new AtomicInteger(0);
        List<Potion> potions = createPotion();

        List<CompletableFuture<Void>> futuresPotions = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potion.gatherIngredients(potion))
                        .thenAccept(sumIngredients::addAndGet))
                .toList();

        CompletableFuture.allOf(futuresPotions.toArray(new CompletableFuture[0])).join();
        System.out.println("Total ingredients collected " + sumIngredients);
    }

    public static List<Potion> createPotion() {
        return Arrays.asList(
                new Potion("Health Potion", 3),
                new Potion("Mana Potion", 4),
                new Potion("Power Potion", 2));
    }
}