package school.faang.task4104;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

class Potion {
    private final String name;
    private final int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    public String getName() {
        return name;
    }

    public int getRequiredIngredients() {
        return requiredIngredients;
    }
}

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenAccept(totalIngredients::addAndGet))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join();

        System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get());
    }

    public static int gatherIngredients(Potion potion) {
        try {
            // Имитация времени сбора ингредиентов
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Собрано " + potion.getRequiredIngredients() + " ингредиентов для зелья: " + potion.getName());
        return potion.getRequiredIngredients();
    }
}
