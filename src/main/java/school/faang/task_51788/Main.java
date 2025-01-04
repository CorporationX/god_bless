package school.faang.task_51788;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    private static void gatherAllIngredients(List<Potion> potions) {
        try {
            List<CompletableFuture<Integer>> result = potions.stream()
                    .map(potion -> gatherIngredients(potion))
                    .toList();
            CompletableFuture<Void> totalResult = CompletableFuture.allOf(result.toArray(new CompletableFuture[0]));
            CompletableFuture<Integer> sum = totalResult.thenApply(res ->
                    result.stream()
                            .map(CompletableFuture::join)
                            .reduce(0, Integer::sum));
                System.out.println("Общее количество собранных ингредиентов: " + sum.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
                return potion.getRequiredIngredients();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
