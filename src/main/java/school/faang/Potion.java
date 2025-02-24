package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Potion {
    private final String name;
    private final int requiredIngredients;
}
