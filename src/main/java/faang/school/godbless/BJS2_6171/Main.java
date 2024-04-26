package faang.school.godbless.BJS2_6171;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        IngredientCollector ingredientCollector = new IngredientCollector();
        SumController sumController = new SumController();
        List<Potion> potions = new ArrayList<>(List.of( new Potion("Яростное зрение", 4),
                new Potion("Слезы зверя", 21), new Potion("Яростное зрение", 86)));

        List<CompletableFuture<Integer>> ingredientList = potions.stream().map(potion ->
                CompletableFuture.supplyAsync(() -> ingredientCollector.gatherIngredients(potion))).toList();

        System.out.println("Необходимое количество ингредиентов: " + sumController.sumElementsFromList(ingredientList));
    }
}
