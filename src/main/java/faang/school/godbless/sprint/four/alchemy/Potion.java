package faang.school.godbless.sprint.four.alchemy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Potion {
    private final String name;
    private int requiredIngredients;
}
