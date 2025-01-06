package derschrank.sprint04.task04.bjstwo_50932;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        PotionService service = new PotionService();

        List<Potion> potions = getPotions();
        int countOfIngredients = service.gatherAllIngredients(potions);

        System.out.println(countOfIngredients);
    }

    private static List<Potion> getPotions() {
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Healing Potion", 5));
        potions.add(new Potion("Mana Potion", 3));
        potions.add(new Potion("Stamina Potion", 4));
        potions.add(new Potion("Healing Potion x 2", 9));
        potions.add(new Potion("Mana Potion x 2", 5));
        potions.add(new Potion("Stamina Potion x 2", 7));
        potions.add(new Potion("Healing Potion x 3", 13));
        potions.add(new Potion("Mana Potion x 3", 7));
        potions.add(new Potion("Stamina Potion x 3", 10));

        return potions;
    }
}
