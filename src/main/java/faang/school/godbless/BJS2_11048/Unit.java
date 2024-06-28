package faang.school.godbless.BJS2_11048;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Unit {
    private int power;

    public Unit(int power) {
        this.power = power;
    }


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
