package school.faang.task_45086;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Category {
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    FOOD("Food"),
    BOOKS("Books");

    private final String name;
}
