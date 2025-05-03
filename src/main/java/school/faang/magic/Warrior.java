package school.faang.magic;

import lombok.Getter;

@Getter
abstract class Warrior {
    protected int power;

    public Warrior(int power) {
        this.power = power;
    }
}