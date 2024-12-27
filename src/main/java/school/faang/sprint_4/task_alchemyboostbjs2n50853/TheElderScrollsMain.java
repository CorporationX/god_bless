package school.faang.sprint_4.task_alchemyboostbjs2n50853;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TheElderScrollsMain {
    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>(List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        ));

        List<CompletableFuture<Integer>> futuresPotions = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> Potion.gatherIngredients(potion)))
                .toList();

        CompletableFuture.allOf(futuresPotions.toArray(new CompletableFuture[0]))
                .join();

        int totalIngredients = futuresPotions.stream()
                .mapToInt(CompletableFuture::join)
                .sum();

        log.info("Общее количество собранных ингредиентов: {}", totalIngredients);
    }
}
