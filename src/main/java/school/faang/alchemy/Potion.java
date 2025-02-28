package school.faang.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Potion {
    private final String name;
    private final int requiredIngredients;
}
