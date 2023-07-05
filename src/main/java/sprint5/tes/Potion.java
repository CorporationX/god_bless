package sprint5.tes;

public record Potion(String name, int requiredIngredients) {
    public int gatherIngredients() {
        int totalCollectionTime = requiredIngredients() * 1000;
        try {
            Thread.sleep(totalCollectionTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return requiredIngredients();
    }
}
