package faang.school.godbless.async.task_6;

import faang.school.godbless.async.task_6.model.Potion;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);
    private static final AtomicInteger NUM_OF_INGREDIENTS = new AtomicInteger(0);

    public static void main(String[] args) {
        List<CompletableFuture<Integer>> gatheringIngredients = new ArrayList<>();
        List<Potion> potions = getPotions();
        potions.forEach(potion -> gatheringIngredients.add(potion.gatherIngredients(potion, EXECUTOR)));
        EXECUTOR.shutdown();
        CompletableFuture.allOf(gatheringIngredients.toArray(new CompletableFuture[0]))
                .thenAccept(v -> gatheringIngredients
                        .forEach(ingredientNumbers -> {
                            try {
                                NUM_OF_INGREDIENTS.addAndGet(ingredientNumbers.get());
                            } catch (InterruptedException | ExecutionException e) {
                                log.error(e.getMessage());
                                e.printStackTrace();
                            }
                        }))
                .thenRun(() -> System.out.println("собрано ингридиентов: " + NUM_OF_INGREDIENTS.get()));
    }

    public static List<Potion> getPotions() {
        Potion first = new Potion("first", 1);
        Potion second = new Potion("second", 2);
        Potion third = new Potion("third", 3);
        Potion fourth = new Potion("fourth", 4);
        Potion fifth = new Potion("fifth", 5);
        return List.of(first, second, third, fourth, fifth);
    }
}