package faang.school.godbless.BJS2_23443;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Unit {
    private int power;

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
