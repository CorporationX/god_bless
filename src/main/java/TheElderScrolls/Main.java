package TheElderScrolls;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger totalIngredients = new AtomicInteger(0);
    private static List<Potion> potions = List.of(
            new Potion("Poison", 5),
            new Potion("Elixir of Vitality", 3),
            new Potion("Tonic of Clarity", 8),
            new Potion("Remedy of Restoration", 1),
            new Potion("Essence of Luck", 4)
            );

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //создать лист фучеров
        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        //вызвать supplyAsync для каждого элемента
        futures = potions.stream().map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        //добавить все в allOf
        CompletableFuture<Void> finalFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        //добавить все полученные результаты в totalIngredients

        }



    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
