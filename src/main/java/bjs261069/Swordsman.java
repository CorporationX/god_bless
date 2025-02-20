package bjs261069;

import lombok.Getter;

@Getter
public class Swordsman extends Fighter {
    private static final int POWER = 40;

    public Swordsman(int power) {
        super();
        this.power = power != 0 ? power : POWER;
    }
}
