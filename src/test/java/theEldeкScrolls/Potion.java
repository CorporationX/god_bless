package theEldeкScrolls;

import java.util.Random;

public class Potion {
    private String name;
    private int requiredIngredients;
    private Random random = new Random();

    public Potion(String name, int requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    public int getRequiredIngredients() {
        return requiredIngredients;
    }
}
