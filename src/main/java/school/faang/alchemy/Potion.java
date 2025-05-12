package school.faang.alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Potion {
    private final String name;
    private final int requiredIngredients;
}
