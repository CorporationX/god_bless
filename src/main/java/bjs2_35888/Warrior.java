package bjs2_35888;

import lombok.Getter;

@Getter
public abstract class Warrior {
    private int power;

    public Warrior(int power) {
        this.power = power;
    }
}
