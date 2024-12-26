package school.faang.sprint_4.task_bjs250922;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Potion(
        @NonNull
        String name,
        int requiredIngredients) {}
