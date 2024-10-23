package Alchemy_BJS2_38815;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public static int gatherIngredients(Potion potion) {
        try {
            System.out.println("Gathering ingredients for potion: " + potion.getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potion.getRequiredIngredients();
    }

    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();

            int totalIngredients = futures.stream()
                    .map(CompletableFuture::join)
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println("Total quantity of ingredients " + totalIngredients);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
