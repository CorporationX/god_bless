package school.faang.potiongathering;

public class Potion {
    private String name;
    private int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    public int getRequiredIngredients() {
        return requiredIngredients;
    }
}

