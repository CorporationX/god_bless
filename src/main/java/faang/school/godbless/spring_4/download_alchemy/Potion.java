package faang.school.godbless.spring_4.download_alchemy;

public class Potion {
    private String name;
    private int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredIngredients() {
        return requiredIngredients;
    }

    public void setRequiredIngredients(int requiredIngredients) {
        this.requiredIngredients = requiredIngredients;
    }
}
