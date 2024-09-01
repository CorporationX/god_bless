package faang.school.godbless.BJS2_25181;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        CompletableFuture<Integer> requiredIngredients = CompletableFuture.supplyAsync(()
                -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        }, executorService);

        return requiredIngredients;
    }

    public static void main(String[] args) {
        List<Potion> potions = Stream.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 4),
                new Potion("Invisibility Potion", 8),
                new Potion("Strength Potion", 6),
                new Potion("Fire Resistance Potion", 7),
                new Potion("Swiftness Potion", 3),
                new Potion("Night Vision Potion", 6),
                new Potion("Regeneration Potion", 9),
                new Potion("Water Breathing Potion", 5),
                new Potion("Leaping Potion", 4)
        ).collect(Collectors.toList());

        List<CompletableFuture<Integer>> completableFutures = potions.stream()
                .map(potion -> gatherIngredients(potion))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allOf.join();

        executorService.shutdown();
    }
}
