package school.faang.heroes;

import lombok.Getter;

@Getter
abstract class Warrior {
    protected final int power;

    Warrior(int power) {
        this.power = power;
    }
}
