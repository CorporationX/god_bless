package school.faang.skillingalchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    private static int gatherIngredients(Potion potion) {

        try {
            TimeUnit.SECONDS.sleep(potion.getRequiredIngredients());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Collected ingredients for: " + potion.getName());

        return potion.getRequiredIngredients();
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                .thenAccept(totalIngredients::addAndGet))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.thenRun(() -> System.out.println("Общее количество собранных ингредиентов: " + totalIngredients.get()))
                .join();

    }
}