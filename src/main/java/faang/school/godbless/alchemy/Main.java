package faang.school.godbless.alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Зелье здоровья", 5));
        potions.add(new Potion("Зелье скорости", 4));
        potions.add(new Potion("Зелье манны", 3));
        AtomicInteger totalIngredients = new AtomicInteger(0);
        List<CompletableFuture<Integer>> ingredientFutures = potions.stream().map(Main::gatherIngredients).toList();
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(ingredientFutures.toArray(new CompletableFuture[0]));
        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        ingredientFutures.forEach(future -> totalIngredients.addAndGet(future.join()));
        System.out.println("Всего собрано ингредиентов: " + totalIngredients.get());

    }

    public static CompletableFuture<Integer> gatherIngredients(Potion potion){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Собрано " + potion.getRequiredIngredients() +" ингредиента(ов) для " + potion.getName());
            return potion.getRequiredIngredients();
        });
    }
}
