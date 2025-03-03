package school.faang.downloadalchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class App {
    private static final List<Potion> potions = List.of(
            new Potion("Healing Potion", 5),
            new Potion("Mana Potion", 3),
            new Potion("Stamina Potion", 4)
    );

    public static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        CompletableFuture<Integer> gatherFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
        return gatherFuture;
    }

    public static void main(String[] args) {
        List<CompletableFuture<Integer>> futures = potions
                .stream()
                .map(App::gatherIngredients)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            int totalIngredients = futures.stream()
                    .mapToInt(CompletableFuture::join)
                    .sum();
            log.info("Общее количество собранных ингредиентов: {}", totalIngredients);
        }).join();
    }
}
