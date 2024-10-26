package school.faang.BJS2_38788;

import lombok.Data;

@Data
public class Potion {
    private String name;
    private int requiredIngredients;

    public Potion(String name, int requiredIngredients) {
        this.requiredIngredients = requiredIngredients;
        this.name = name;
    }
}
