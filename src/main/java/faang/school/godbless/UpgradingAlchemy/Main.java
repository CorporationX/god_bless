package faang.school.godbless.UpgradingAlchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GatheringIngredients gatheringIngredients = new GatheringIngredients();
        List<Potion> potions = getPotions();

        gatheringIngredients.allIngredientsCalculator(potions);
        log.info(String.valueOf(gatheringIngredients.getNumOfAllIngredients().get()));
        gatheringIngredients.shutdownGatherIngredients();
    }

    public static List<Potion> getPotions() {
        return List.of(
                new Potion("potionOne", List.of("stone", "sand")),
                new Potion("potionTwo", List.of("strawberry", "apple"))
        );
    }
}
