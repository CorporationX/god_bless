package faang.school.godbless.gain_alch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static faang.school.godbless.gain_alch.Potion.gatherIngredients;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();

        potions.add(new Potion("Health potion", 2));
        potions.add(new Potion("Big health potion", 3));
        potions.add(new Potion("Invisibility potion", 3));
        potions.add(new Potion("Regeneration potion", 2));
        potions.add(new Potion("Mana potion", 2));
        potions.add(new Potion("Stamina potion", 2));
        potions.add(new Potion("Strength potion", 3));

        List<CompletableFuture<Integer>> completableFuture = potions.stream()
                .map(Potion::gatherIngredients)
                .toList();

        AtomicInteger sumOfAllIngredients = new AtomicInteger(0);

        CompletableFuture.allOf(completableFuture.toArray(new CompletableFuture[0]))
                .thenRunAsync(() -> completableFuture.forEach(r ->
                        sumOfAllIngredients.getAndAdd(r.join())))
                .join();
        log.info("Total ingredients: " + sumOfAllIngredients);
    }
}
