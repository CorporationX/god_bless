package school.faang.task62549;

import school.faang.task62549.service.Potion;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Зелье здоровья", 5),
                new Potion("Зелье маны", 3),
                new Potion("Зелье выносливости", 4)
        );
        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        AtomicInteger totalIngredients = new AtomicInteger(0);

        allOf.thenRun(() -> {
            futures.forEach(future -> future.thenAccept(totalIngredients::addAndGet));
            System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
        }).join();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Начинаем сбор ингредиентов для " + potion.getName());
                Thread.sleep(potion.getRequiredIngredients() * 1000L);
                System.out.println("Завершен сбор ингредиентов для " + potion.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
