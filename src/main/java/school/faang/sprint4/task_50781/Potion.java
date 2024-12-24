package school.faang.sprint4.task_50781;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Potion {
    @NonNull
    private final String name;
    private final int requiredIngredients;
}
