package school.faang.sprint_4.task_43583;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    private static final int THREAD_SLEEP = 2000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> ingredientsFutures = potions
                .stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture.allOf(ingredientsFutures.toArray(new CompletableFuture[0])).join();

        AtomicInteger totalIngredients = new AtomicInteger(0);
        ingredientsFutures.forEach(potion -> totalIngredients.addAndGet(potion.join()));

        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Собираем ингредиенты для " + potion.name());
            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван во время сбора ингредиентов.");
            }
            int ingredients = potion.requiredIngredients();
            System.out.println("Для зелья " + potion.name() + " собрано ингредиентов: " + ingredients);
            return ingredients;
        });
    }
}