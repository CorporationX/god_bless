package school.faang.task_50753;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("potionName");
        }

        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }
}
