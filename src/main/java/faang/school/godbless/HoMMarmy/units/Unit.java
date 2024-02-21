package faang.school.godbless.HoMMarmy.units;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public abstract class Unit {

    private int power;
    private int count;

    public Unit(int power) {
        this.power = power;
        this.count = 1;
    }
}
