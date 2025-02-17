package bjs261069;

import lombok.Getter;

@Getter
public class Archer extends Fighter {
    private final int power;

    public Archer(int power) {
        super();
        this.power = power != 0 ? power : 25;
    }
}
