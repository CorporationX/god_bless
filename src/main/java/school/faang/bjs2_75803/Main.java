package school.faang.bjs2_75803;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static school.faang.bjs2_75803.PotionService.totalIngredients;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<Potion> potions = new ArrayList<>(List.of(new Potion("1", 1),
                new Potion("2", 2),
                new Potion("3", 3)));

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionService::gatherIngredients)
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        log.info("Всего индгредиентов собрано {}", totalIngredients);
    }
}
