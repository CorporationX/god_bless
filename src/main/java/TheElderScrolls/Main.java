package TheElderScrolls;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    private static int totalIngredients = 0;
    private static final List<Potion> potions = List.of(
            new Potion("Poison", 5),
            new Potion("Elixir of Vitality", 3),
            new Potion("Tonic of Clarity", 8),
            new Potion("Remedy of Restoration", 1),
            new Potion("Essence of Luck", 4)
    );

    public static void main(String[] args) {
        //создать лист фучеров
        List<CompletableFuture<Integer>> futures;

        //вызвать supplyAsync для каждого элемента
        futures = potions.stream().map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        //добавить все в allOf
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        //Дождаться выполнения всех задач
        allFutures.join();

        //сложить все полученные результаты в totalIngredients
        totalIngredients = futures.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).reduce(0, Integer::sum);

        System.out.println(totalIngredients);
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
