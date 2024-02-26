package faang.school.godbless.alchemy;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        PotionService potionService = new PotionService(getPotions());

        int gatheredIngredients = potionService.gatherAllIngredients();

        potionService.shutdownAndAwaitExecutor();
        System.out.println(String.format("Gathered ingredients: %d", gatheredIngredients));
    }

    private static List<Potion> getPotions() {
        return List.of(new Potion("Levitation", 5),
                new Potion("Invisibility", 3),
                new Potion("Strength", 2));
    }
}
