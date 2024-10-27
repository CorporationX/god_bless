package school.faang.sprint4.ingridients;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        gatherAllIngredients(potions);
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> listIngredients = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Invalid async");
                    }
                    return potion.getRequiredIngredients();
                })).toList();

        CompletableFuture.allOf(listIngredients.toArray(new CompletableFuture[0]))
                .thenApply(k -> listIngredients.stream().map(CompletableFuture::join)
                .reduce(Integer::sum).orElse(0))
                .thenAccept(totalIngredients -> System.out.println("Общее количество собранных ингредиентов: " + totalIngredients));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Invalid async");
        }
    }
}
