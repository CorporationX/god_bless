package school.faang.magicAndMight2;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Unit {
    protected int power;

    public Unit(int power) {
        this.power = power;
    }
}
