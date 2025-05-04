package school.faang.bjs251096;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Potion {

    private final String name;
    private final int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        if (name == null || name.trim().isEmpty() || requiredIngredients <= 0) {
            log.error("Potion name cannot be null or empty and requiredIngredients cannot be <= 0");
            throw new IllegalArgumentException("Potion name cannot be null "
                    + "or empty and requiredIngredients cannot be <= 0");
        }
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }
}
