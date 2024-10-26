package school.faang.BJS2_38788;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GatherIngredients gather = new GatherIngredients();
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4),
                new Potion("Invisibility Potion", 7),
                new Potion("Power Potion", 2)
        );

        gather.gatherAllIngredients(potions);
        gather.shutdown();
    }
}
