package alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Potion {
    String name;
    int requiredIngredients;
}
