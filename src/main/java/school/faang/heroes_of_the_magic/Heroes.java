package school.faang.heroes_of_the_magic;

import lombok.Getter;

public abstract class Heroes {
    @Getter
    private final int power;

    public Heroes(int defaultPower) {
        this.power = defaultPower;
    }
}
