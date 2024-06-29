package faang.school.godbless.potion;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@AllArgsConstructor
public class Potion {
    private static final Random random = new Random();
    private String name;
    private List<String> requiredIngredients;


    public String gatherIngredients(CopyOnWriteArrayList<String> ingredientsPantry) {
        if (ingredientsPantry == null) {
            throw new IllegalArgumentException("In gatherIngredients method Potion class apply ConcurrentLinkedDeque is null");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(
                    "Exception for sending a thread to sleep in the gather Ingredients method of the Potion class", e);
        }
        if (ingredientsPantry.isEmpty()) {
            return "There are no more ingredients in the pantry";
        }
        if (ingredientsPantry.containsAll(requiredIngredients)) {
            ingredientsPantry.removeAll(requiredIngredients);
            return String.format("%s potion successfully created", name);
        } else {
            return String.format("Not enough ingredients to create a %s potion", name);
        }
    }

    public static List<String> generateThirtyIngredientsInPantry() {
        List<String> pantry = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            pantry.add(String.format("potion №%d", random.nextInt(1, 7)));
        }
        return pantry;
    }

    public static List<Potion> generateFivePotion() {
        List<Potion> potion = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(1, 7);
            List<String> potionRecipe = new ArrayList<>();
            for (int j = 0; j < randomNumber; j++) {
                potionRecipe.add(String.format("potion №%d", randomNumber));
            }
            potion.add(new Potion(String.format("potion №%d", randomNumber), potionRecipe));
        }
        return potion;
    }
}
