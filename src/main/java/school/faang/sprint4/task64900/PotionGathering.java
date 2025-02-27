package school.faang.sprint4.task64900;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PotionGathering {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        PotionGathering potionGathering = new PotionGathering();
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (Potion potion : potions) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->
                    potionGathering.gatheringIngredients(potion));
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }



    public int gatheringIngredients(Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * 1000L);
        } catch (InterruptedException e) {
            log.warn("[{}] [{}] was interrupted", System.currentTimeMillis(), Thread.currentThread().getName());
        }
        return potion.getRequiredIngredients();
    }
}
