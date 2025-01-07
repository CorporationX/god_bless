package school.faang.task_51204;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        final AtomicInteger totalIngredients = new AtomicInteger();

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenAccept(totalIngredients::addAndGet))
                .collect(Collectors.toList());


        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                    .thenRun(() -> log.info("Total amount collected ingredients: {}", totalIngredients.get()))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static int gatherIngredients(Potion potion) {
        try {
            log.info("The collection of ingredients for: {}", potion.name());
            Thread.sleep(potion.requiredIngredients() * 1000L);
            log.info("The ingredients for {} are collected: {}", potion.name(), potion.requiredIngredients());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("The collection of ingredients for {} was interrupted", potion.name());
        }

        return potion.requiredIngredients();
    }
}
