package faang.school.godbless.DownloadingAlchemy;

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

    public int getRequiredIngredients() {
        return requiredIngredients;
    }
}
