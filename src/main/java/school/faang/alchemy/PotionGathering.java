package school.faang.alchemy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {

    public static void main(String[] args) {
        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        List<CompletableFuture<Integer>> cfs = potions.stream().map(potion -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * potion.getIngredients());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("Сбор ингредиентов для %s завершился неудачно%n", potion.getName());
                throw new RuntimeException(e);
            }
            totalIngredients.addAndGet(potion.getIngredients());
            return potion.getIngredients();
        })
        ).toList();


        CompletableFuture.allOf(cfs.toArray(CompletableFuture[]::new));
        int total = totalIngredients.get();
        System.out.println("Общее количество собранных ингредиентов: " + total);
    }
}
