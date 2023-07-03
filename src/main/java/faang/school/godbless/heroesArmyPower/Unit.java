package faang.school.godbless.heroesArmyPower;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Unit {
    private int power;

    public boolean isArcher() {
        return false;
    }

    public boolean isSwordsman() {
        return false;
    }

    public boolean isMage() {
        return false;
    }
}
