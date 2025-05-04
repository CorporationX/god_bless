package school.faang.async.bjs2_75062;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = Stream.concat(
                Stream.of(
                        new Potion("Healing Potion", 5),
                        new Potion("Mana Potion", 3),
                        new Potion("Stamina Potion", 4)
                ),
                Stream.generate(() -> new Potion("Potion", 1))
                        .limit(8)
        ).toList();

        new PotionGathering(potions).gatherAllIngredients();
    }
}
