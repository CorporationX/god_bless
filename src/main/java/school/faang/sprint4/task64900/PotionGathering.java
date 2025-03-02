package school.faang.sprint4.task64900;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PotionGathering {
    private static final long FACTOR = 1_000L;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionGathering potionGathering = new PotionGathering();

        List<CompletableFuture<Integer>> futuresList = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> potionGathering.gatheringIngredients(potion)))
                .toList();

        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]));
        voidCompletableFuture.join();

        int totalIngredientsNumber = futuresList.stream().mapToInt(CompletableFuture::join).sum();
        System.out.printf("\nTotal ingredients number: %d", totalIngredientsNumber);
    }


    public int gatheringIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * FACTOR);
        } catch (InterruptedException e) {
            log.warn("[{}] [{}] was interrupted", System.currentTimeMillis(), Thread.currentThread().getName());
        }
        return potion.getRequiredIngredients();
    }
}
