package faang.school.godbless.BJS2_14203;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Potion {
    private String name;
    private Map<String, Integer> requiredIngredients;
}
