package school.faang.task_62558;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Potion {
    @NonNull
    private String name;
    private int requiredIngredients;
}
