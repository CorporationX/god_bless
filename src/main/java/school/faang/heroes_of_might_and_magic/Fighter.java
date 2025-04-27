package school.faang.heroes_of_might_and_magic;

import lombok.Getter;

abstract class Fighter {

    @Getter
    private int power;

    public Fighter(int power) {
        this.power = power;
    }
}
