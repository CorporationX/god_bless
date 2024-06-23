package faang.school.godbless.multithreading.parallelism.armyOfHeroes;

import lombok.Data;

@Data
public abstract class Unit {
    private int power;

    public Unit(int power) {
        this.power = power;
    }
}
