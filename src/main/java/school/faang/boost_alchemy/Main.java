package school.faang.boost_alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Super Potion", 9),
                new Potion("Dead Potion", 8),
                new Potion("Philtre Potion", 6)
        );

        PotionMaker potionMaker = new PotionMaker();
        potionMaker.countAllIngredients(potions);

        int sum = potionMaker.getTotalIngredients().get();
        log.info("Total ingredients necessary for all potions {}", sum);
    }
}