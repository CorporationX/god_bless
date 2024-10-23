package school.faang.Multithreading.sprint_4.Alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions){
        List<CompletableFuture<Integer>> futureIngredients = potions.stream()
                .map(potion -> potion.gatherIngredients(potion))
                .toList();

        AtomicInteger allIngredient = new AtomicInteger(0);
        futureIngredients.forEach(futureIngredient -> allIngredient.addAndGet(futureIngredient.join()));

        System.out.println("Общее количество собранных ингредиентов: " + allIngredient.get());
    }
}
