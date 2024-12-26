package school.faang.task_50743;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionGathering potionGathering = new PotionGathering();

        log.info("Total number of ingredients collected: {}", potionGathering.gatherAllIngredients(potions).join());

        potionGathering.terminate();
    }
}
