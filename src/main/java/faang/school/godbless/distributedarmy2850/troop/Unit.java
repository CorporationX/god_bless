package faang.school.godbless.distributedarmy2850.troop;

import lombok.Getter;

@Getter
public abstract class Unit {
    private int power;

    Unit(int power) {
        this.power = power;
    }
}
