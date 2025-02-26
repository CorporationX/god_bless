package school.faang.sprint.fourth.elder;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Potion {
    @NonNull
    private String name;
    private int requiredIngredients;

    public Potion(@NonNull String name, int requiredIngredients) {
        validateData(name, requiredIngredients);
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    private void validateData(@NonNull String name, int requiredIngredients) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (requiredIngredients <= 0) {
            throw new IllegalArgumentException("Required ingredients must be greater than 0");
        }
    }
}
