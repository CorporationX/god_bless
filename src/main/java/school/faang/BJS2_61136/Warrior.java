package school.faang.BJS2_61136;

import lombok.Getter;

@Getter
public abstract class Warrior {

    private final int power;

    public Warrior(int power) {
        this.power = power;
    }
}
