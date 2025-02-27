package school.faang.pumping_alchemy.BJS2_62626;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PotionGathering potionGathering = new PotionGathering();
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        List<CompletableFuture<Integer>> futures = potionGathering.gatherAllIngredients(potions);
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.info("Количество необходимых ингредиентов {}", futures.stream()
                .mapToInt(CompletableFuture::join)
                .sum());
    }
}
