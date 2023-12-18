package faang.school.godbless.ArmyHeroesMightAndMagic;

import lombok.Data;

@Data
public abstract class Unit {
    protected final int power;

    protected Unit(int power) {
        this.power = power;
    }
}
