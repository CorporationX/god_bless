package theEldeкScrolls;

import java.util.Random;

public class Potion {
    private String name;
    private int requiredIngredients;
    Random random = new Random();

    public Potion(String name, int requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    public synchronized int getRequiredIngredients() {
        return requiredIngredients;
    }
}
