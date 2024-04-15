package faang.school.godbless.HerosAndMagicArmy;

import lombok.Data;

@Data
public abstract class Unit {
    private int power;

    public Unit(int power) {
        this.power = power;
    }
}
