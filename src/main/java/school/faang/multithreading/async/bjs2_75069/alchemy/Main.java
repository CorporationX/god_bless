package school.faang.multithreading.async.bjs2_75069.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Potion #1", 1),
                new Potion("Potion #2", 2),
                new Potion("Potion #3", 3),
                new Potion("Potion #4", 4),
                new Potion("Potion #5", 5)
        );

        PotionCollector potionCollector = new PotionCollector(potions);
        int totalIngredients = potionCollector.gatherAllIngredients();
        log.info("Total ingredients: {}", totalIngredients);
    }
}
