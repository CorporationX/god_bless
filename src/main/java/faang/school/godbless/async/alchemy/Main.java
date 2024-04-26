package faang.school.godbless.async.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final List<Potion> POTIONS;

    static {
        POTIONS = new ArrayList<>();

        POTIONS.add(new Potion("Health Potion", 3));
        POTIONS.add(new Potion("Strength Potion", 2));
        POTIONS.add(new Potion("Potion of Swiftness", 2));
        POTIONS.add(new Potion("Potion of Agility", 2));
        POTIONS.add(new Potion("Luck Potion", 1));
        POTIONS.add(new Potion("Potion of Slowing", 2));
        POTIONS.add(new Potion("Potion of Insight", 3));
        POTIONS.add(new Potion("Potion of Intelligence", 3));
        POTIONS.add(new Potion("Potion of Protection", 2));
        POTIONS.add(new Potion("Fire Resistance Potion", 2));
        POTIONS.add(new Potion("Healing Potion", 3));
        POTIONS.add(new Potion("Potion of Transformation", 4));
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<CompletableFuture<Integer>> gatheredIngredients = new ArrayList<>();


        POTIONS.forEach(potion -> gatheredIngredients.add(Potion.gatherIngredients(potion, pool)));

        pool.shutdown();

        CompletableFuture.allOf(gatheredIngredients.toArray(new CompletableFuture[0]))
                .thenApply((f) -> {
                    var result = gatheredIngredients.stream()
                            .map(CompletableFuture::join)
                            .reduce(0, Integer::sum);

                    log.info("The total amount of gathered ingredients is " + result);

                    return result;
                });
    }
}
