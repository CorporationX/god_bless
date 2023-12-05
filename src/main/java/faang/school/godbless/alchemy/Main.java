package faang.school.godbless.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        List<Potion> potionList = List.of(
                new Potion("potion1", 2),
                new Potion("potion2", 3),
                new Potion("potion3", 5),
                new Potion("potion4", 7),
                new Potion("potion5", 9)
        );

        List<CompletableFuture<Integer>> ingredientTasks = potionList.stream()
                .map(Main::gatherIngredients)
                .toList();

        CompletableFuture<Void> allIngredientsTask = CompletableFuture.allOf(
                ingredientTasks.toArray(new CompletableFuture[0]));

        CompletableFuture<Integer> sum = allIngredientsTask.thenApply(
                task -> ingredientTasks.stream()
                        .map(CompletableFuture::join)
                        .reduce(0, Integer::sum)
        );

        try {
            System.out.println(sum.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ingredients gathered for: " + potion.getName());
            return potion.getRequiredIngredients();
        });
    }
}
