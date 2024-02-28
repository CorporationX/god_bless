package faang.school.godbless.alchemy;

public class Potion {
    private final String name;
    private final int requiredIngredients;

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
}
