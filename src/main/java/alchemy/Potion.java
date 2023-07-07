package alchemy;

public class Potion {
    private String name;
    private int requiredIngredients;
    private int collectedIngredients = 0;

    public Potion(String name, int requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    public String getName() {
        return name;
    }

    public int getRequiredIngredients() {
        return requiredIngredients;
    }

    public void addIngredient() {
        collectedIngredients++;
    }
}
