package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PotionGathering {
    private static final int SLEEP_TIME_MS = 1000;

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        int allIngredients = gatherAllIngredients(potions);
        log.info("Общее количество собранных ингредиентов: {}", allIngredients);
    }

    private static int gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> features = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredient(potion)))
                .toList();

        CompletableFuture.allOf(features.toArray(new CompletableFuture[0])).join();

        return features.stream()
                .mapToInt(CompletableFuture::join)
                .sum();

    }

    private static int gatherIngredient(Potion potion) {
        try {
            log.info("Сбор ингредиентов для зелья {}", potion.name());
            Thread.sleep((long) SLEEP_TIME_MS * potion.requiredIngredients());
            log.info("Для зелья {} собраны все ингредиенты - {}", potion.name(), potion.requiredIngredients());
            return potion.requiredIngredients();
        } catch (InterruptedException e) {
            log.error("Поток прерван {}", e.getMessage(), e);
            throw new RuntimeException("Ошибка при сборе ингредиентов для зелья " + potion.requiredIngredients(), e);
        }
    }
}
