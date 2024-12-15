package school.faang.task48208;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HouseholdChores {
    TABLEWARE("помыть посуду"),
    FLOOR("помыть пол"),
    FOOD("приготовить еду");

    private final String chore;
}
