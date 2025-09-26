package school.faang.bjs291341.warrior;

import lombok.Getter;

@Getter
public abstract class Unit {
    private Integer power;

    public Unit(Integer power) {
        this.power = power;
    }
}
