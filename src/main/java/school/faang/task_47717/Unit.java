package school.faang.task_47717;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Unit {
    protected int power;

    public boolean isMage() {
        return false;
    }

    public boolean isSwordsman() {
        return false;
    }

    public boolean isArcher() {
        return false;
    }
}
