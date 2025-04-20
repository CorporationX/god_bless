package school.faang.hero;

import lombok.Getter;

@Getter
public abstract class Hero {
    private final int power;

    protected Hero(int power) {
        this.power = power;
    }
}