package faang.school.godbless.Task_Leveling_Alchemy;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Potion {
    private String name;
    private int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        if (name.isBlank() || requiredIngredients <= 0) throw new IllegalArgumentException("invalid arg(s)");
        else {
            this.name = name;
            this.requiredIngredients = requiredIngredients;
        }
    }
}
