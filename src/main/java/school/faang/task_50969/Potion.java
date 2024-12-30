package school.faang.task_50969;

public record Potion(String name, int requiredIngredients) {
    public Potion {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
