package dima.evseenko.alchemist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;
}
