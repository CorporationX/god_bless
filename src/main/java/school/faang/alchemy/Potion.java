package school.faang.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Potion {
    private final String name;
    private final int requiredIngredients;
}
