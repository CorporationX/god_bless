package bjs261069;

import lombok.Getter;

@Getter
public class Mage extends Fighter {
    private static final int POWER = 50;

    public Mage(int power) {
        super();
        this.power = power != 0 ? power : POWER;
    }
}
