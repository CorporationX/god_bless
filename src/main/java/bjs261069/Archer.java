package bjs261069;

import lombok.Getter;

@Getter
public class Archer extends Fighter {
    private static final int POWER = 25;

    public Archer(int power) {
        super();
        this.power = power != 0 ? power : POWER;
    }
}
