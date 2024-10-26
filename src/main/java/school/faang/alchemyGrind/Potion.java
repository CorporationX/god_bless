package school.faang.alchemyGrind;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Potion {
    private String name;
    private int requireIngredients;

    public Potion(String name, int requireIngredients) {
        this.name = "Зелье "+ name;
        this.requireIngredients = requireIngredients;
    }
}
