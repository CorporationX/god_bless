package faang.school.godbless.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Potion {
    private String name;
    private List<Integer> requiredIngredients;
}
