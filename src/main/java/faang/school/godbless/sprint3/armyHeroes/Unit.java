package faang.school.godbless.sprint3.armyHeroes;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public abstract class Unit {
    @Setter
    private String name;
    private final int power;

    public Unit(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(name, unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
