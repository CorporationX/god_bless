package school.faang.bjs2_91272.character;

import lombok.Getter;

@Getter
public abstract class Unit {
    private final int power;

    public Unit(int power) {
        this.power = power;
    }
}
