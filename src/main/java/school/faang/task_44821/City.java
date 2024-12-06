package school.faang.task_44821;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum City {
    MOSCOW("Moscow"),
    KAZAN("Kazan"),
    STERLITAMAK("Sterlitamak");

    private final String name;
}
