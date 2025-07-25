package school.faang.s_4_1_grinding_alchemy;

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

    public int gatheringIngredients() {
        try {
            System.out.println("Gathering ingredients...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return this.requiredIngredients;
    }
}
