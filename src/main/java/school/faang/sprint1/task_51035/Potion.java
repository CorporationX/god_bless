package school.faang.sprint1.task_51035;

import lombok.Getter;

@Getter
public class Potion {

    private final String name;
    private final int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }
}
