package school.faang.sprint_3.task_bjs247927;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public abstract class Unit {
    private final int power;
    private final UnitType type;
}
