package school.faang.boost_alchemy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Potion {
    private final String name;
    @Getter
    private final int requiredIngredients;
}
