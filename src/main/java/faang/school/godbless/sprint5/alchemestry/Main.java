package faang.school.godbless.sprint5.alchemestry;

import faang.school.godbless.sprint5.alchemestry.classes.Potion;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {
        List<Potion> list = List.of(
                new Potion("Dark Potion", 10),
                new Potion("Fire Potion", 3),
                new Potion("Ice Potion", 6),
                new Potion("Light Potion", 4),
                new Potion("Water Potion", 1)
        );
        List<CompletableFuture<Integer>> futures = list.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredient(potion)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Gathered ingredients: " + counter.get());
    }

    @SneakyThrows
    public static int gatherIngredient(Potion potion) {
        int requiredIngredients = potion.getRequiredIngredients();
        Thread.sleep(requiredIngredients * 1000L);
        System.out.println("Gathered ingredients for " + potion.getName());
        return counter.addAndGet(requiredIngredients);
    }
}