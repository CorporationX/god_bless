package faang.school.godbless.sprint3.armyHeroes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(exclude = "power")
public abstract class Unit {
    @Setter
    private String name;
    private final int power;

    public Unit(int power) {
        this.power = power;
    }
}
