package school.faang.stream4.alchemyleveling;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(2000);
                return potion.getRequiredIngredients();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                return 0;
            }
        });
    }

    public static CompletableFuture<Integer> gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures =
                potions.stream()
                        .map(Main::gatherIngredients)
                        .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .mapToInt(CompletableFuture::join)
                        .sum());
    }


    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions)
                .thenAcceptAsync(result ->
                        System.out.printf("Общее количество собранных ингредиентов: %d", result))
                .join();
    }
}
