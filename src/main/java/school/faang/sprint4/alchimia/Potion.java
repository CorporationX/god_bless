package school.faang.sprint4.alchimia;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private Integer requiredIngredients;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion!", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    public static Integer gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futurePotion = new ArrayList<>();
        for (Potion potion : potions) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000 * potion.requiredIngredients);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return potion.requiredIngredients;
            });
            futurePotion.add(future);
        }
        Integer sumRequiredIngredients = CompletableFuture
                .allOf(futurePotion.toArray(new CompletableFuture[0]))
                .thenApply((v) -> futurePotion.stream()
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum)).join();

        System.out.println(sumRequiredIngredients);
        return sumRequiredIngredients;
    }

}


