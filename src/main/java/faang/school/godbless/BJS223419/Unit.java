package faang.school.godbless.BJS223419;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Unit {
    private int power;

    public boolean isMage() {
        return false;
    }

    public boolean isArcher() {
        return false;
    }

    public boolean isSwordsman() {
        return false;
    }
}
