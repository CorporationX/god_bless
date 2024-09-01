package improving_alchemistry;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Potion {
    private final String name;
    private final int requiredIngredients;
}
