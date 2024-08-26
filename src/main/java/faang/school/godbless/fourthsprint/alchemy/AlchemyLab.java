package faang.school.godbless.fourthsprint.alchemy;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AlchemyLab {
    private static final int MAX_WAIT_TIME = 7;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, MAX_WAIT_TIME));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Collected " + potion.getRequiredIngredients() + " ingredients for " + potion.getName());
            return potion.getRequiredIngredients();
        });
    }

    public static void main(String[] args) {
        List<Potion> potions = getPotions();

        AtomicInteger totalIngredients = new AtomicInteger();

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> gatherIngredients(potion).thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("\nTotal ingredients collected: " + totalIngredients.get());
    }

    public static List<Potion> getPotions() {
        return Arrays.asList(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Invisibility Potion", 7),
                new Potion("Strength Potion", 6)
        );
    }
}
