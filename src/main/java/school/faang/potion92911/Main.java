package school.faang.potion92911;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(p -> CompletableFuture.supplyAsync(() -> Potion.gatherIngredients(p)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        CompletableFuture<Integer> totalIngredients = allFutures.thenApply(v ->
                futures.stream().mapToInt(CompletableFuture::join).sum());

        System.out.println("Total ingredients gathered: " + totalIngredients.join());
    }
}
