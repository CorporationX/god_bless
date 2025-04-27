package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        PotionGatheringService service = new PotionGatheringService();
        service.gatherAllIngredients(potions);
    }
}
