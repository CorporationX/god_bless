package school.faang.sprint_3.task_47956;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Unit {
    private int power;

    public abstract String getUnitType();
}
